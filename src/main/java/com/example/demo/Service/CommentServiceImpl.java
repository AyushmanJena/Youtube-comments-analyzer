package com.example.demo.Service;

import com.example.demo.Model.CommentsModel;
import com.example.demo.Model.VideoModel;
import com.example.demo.Response.CommentResponse;
import com.example.demo.Response.PlaylistResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

@Service
public class CommentServiceImpl implements CommentService {
    // test video id = "TYYkFky5pkA";
    // test playlist id = "PLHD9dyKTwCNKP-vxlnLNCJxAoTkzLD_GX"
    // "https://www.googleapis.com/youtube/v3/commentThreads?key=---------------------------&textFormat=plainText&part=snippet&videoId=TYYkFky5pkA&maxResults=50"
    // "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=PLHD9dyKTwCNKP-vxlnLNCJxAoTkzLD_GX&key=--------------------"

    private final int resultsCount = 5; // number of results to get for each order
    private final String API = "https://www.googleapis.com/youtube/v3/commentThreads?maxResults="+resultsCount+"&textFormat=plainText&part=snippet";
    private final String playlistAPI = "https://www.googleapis.com/youtube/v3/playlistItems?part=snippet&maxResults=50&playlistId=";

    @Value("${yt.api.key}")
    private String key;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public CommentResponse getTopCommentsList(String videoId) throws Exception {  // returns the whole response for a single video
        String api = API + "&key="+ key + "&videoId=" + videoId;
        ResponseEntity<CommentResponse> response = restTemplate.exchange(api, HttpMethod.GET, null, CommentResponse.class);
        CommentResponse body = response.getBody();
        return body;
    }

    @Override
    public PlaylistResponse getPlaylistList(String playlistId) { // returns the whole response for playlist
        String api = playlistAPI + playlistId + "&key=" + key;
        ResponseEntity<PlaylistResponse> response;
        PlaylistResponse playlistResponse = new PlaylistResponse();
        try{
            response = restTemplate.exchange(api, HttpMethod.GET, null, PlaylistResponse.class);
        }catch(Exception e){
            System.out.println("Playlist error");
            return playlistResponse;
        }
        playlistResponse = response.getBody();
        return playlistResponse;
    }

    @Override
    public ArrayList<CommentsModel> getComments(String videoId) { // takes video link and return list of comments
        HashMap<String, CommentsModel> map = new HashMap();

        ArrayList<CommentsModel> recentComments = getCommentWithOrder(videoId, "time");
        ArrayList<CommentsModel> relevantComments = getCommentWithOrder(videoId, "relevance");

        // making sure the comments are not duplicated
        if(recentComments.size() < resultsCount){
            return recentComments;
        }

        for(CommentsModel comment : recentComments){
            map.put(comment.getText(), comment);
        }
        for(CommentsModel comment : relevantComments){
            map.put(comment.getText(), comment);
        }

        ArrayList<CommentsModel> recentAndRelevantComments = new ArrayList<>();
        for(String text : map.keySet()){
            recentAndRelevantComments.add(map.get(text));
        }

        return recentAndRelevantComments;
    }

    @Override
    public ArrayList<VideoModel> getPlaylistComments(String playlistId) { // returns the model data for playlist
        ArrayList<VideoModel> result = new ArrayList<>();
        PlaylistResponse playlist = getPlaylistList(playlistId);
        if(playlist.getItems() != null){
            for(PlaylistResponse.Item item : playlist.getItems()) {
                if(item.getSnippet() != null && item.getId() != null){
                    String videoId = item.getSnippet().getResourceId().getVideoId();
                    String title = item.getSnippet().getTitle();
                    ArrayList<CommentsModel> comments = getComments(videoId);
                    result.add(new VideoModel(videoId, title, 0, 0, comments));
                }
            }
        }
        return result;
    }

    @Override
    public ArrayList<CommentsModel> getCommentWithOrder(String videoId, String order) { // order can be relevance or time only
        String api = API + " &key="+ key + "&videoId=" + videoId + "&order=" + order;
        ResponseEntity<CommentResponse> response;
        try{
            response = restTemplate.exchange(api, HttpMethod.GET, null, CommentResponse.class);
        }catch(Exception e){
            System.out.println("Comments Error");
            return new ArrayList<>();
        }
        CommentResponse body = response.getBody();
        ArrayList<CommentsModel> comments = new ArrayList<>();

        if(body.getItems() != null){
            for(CommentResponse.Item item : body.getItems()){
                if(item.getSnippet() != null && item.getSnippet().getTopLevelComment() != null && item.getSnippet().getTopLevelComment().getSnippet() != null){
                    String text = item.getSnippet().getTopLevelComment().getSnippet().getTextOriginal();
                    int likeCount = item.getSnippet().getTopLevelComment().getSnippet().getLikeCount();
                    String updatedDate = item.getSnippet().getTopLevelComment().getSnippet().getUpdatedAt();
                    // System.out.println(text);
                    comments.add(new CommentsModel(text, likeCount, updatedDate));
                }
            }
        }
        return comments;
    }
}
