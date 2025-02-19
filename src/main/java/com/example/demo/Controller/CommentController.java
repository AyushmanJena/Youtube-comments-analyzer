package com.example.demo.Controller;

import com.example.demo.Model.CommentsModel;
import com.example.demo.Model.VideoModel;
import com.example.demo.Response.CommentResponse;
import com.example.demo.Response.PlaylistResponse;
import com.example.demo.Service.CommentService;
import com.example.demo.Service.LLMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private LLMService llmService;

    @GetMapping("/testvideo")
    public void getComments(){ // change to ResponseEntity
        //String testVideoId = "oDplLI2LtsU"; // video with comments turned off
        String testVideoId = "70tx7KcMROc"; // kunal kushwaha linked list video
        ArrayList<CommentsModel> relevantData = commentService.getComments(testVideoId); // video id
        String result = llmService.getVideoReview(relevantData);
        System.out.println(result);
        // displayCommentsOfVideo(relevantData);
    }

    @GetMapping("/testplaylist")
    public void getPlaylistDetails(){
        String testPlaylistId = "PLKl5GqiLaCq3XBSy-vM2_CsZ5HQK4vGR_"; // Educational videos playlist
        // String testPlaylistId = "PLHD9dyKTwCNKP-vxlnLNCJxAoTkzLD_GX"; // some random ess videos playlist
        ArrayList<VideoModel> videos = commentService.getPlaylistComments(testPlaylistId);
        ArrayList<String> result = llmService.getPlaylistReview(videos);
        for(String str : result){
            System.out.println(str);
        }
        // displayCommentsOfPlaylist(videos);
    }

    // with custom video in the url
    @GetMapping("/video/{videoId}")
    public void getVideoCommentDetails(@PathVariable String videoId){
        ArrayList<CommentsModel> relevantData = commentService.getComments(videoId); // video id
        String result = llmService.getVideoReview(relevantData);
        System.out.println(result);
    }

    // with custom playlist in the url
    @GetMapping("/playlist/{playlistId}")
    public void getPlaylistCommentDetails(@PathVariable String playlistId){
        ArrayList<VideoModel> videos = commentService.getPlaylistComments(playlistId);
        ArrayList<String> result = llmService.getPlaylistReview(videos);
        for(String str : result){
            System.out.println(str);
        }
    }

    public void displayCommentsOfVideo(ArrayList<CommentsModel> commentsModels){
        for(CommentsModel comment : commentsModels){
            System.out.println("comment : " + comment.getText());
            System.out.println("Like count : " + comment.getLikeCount());
            System.out.println("Updated At : " + comment.getUpdatedAt());
            System.out.println("-----------------------------------------------------------------------");
        }
    }

    public void displayCommentsOfPlaylist(ArrayList<VideoModel> videos){
        for(VideoModel video : videos){
            System.out.println("TITLE : " + video.getTitle());
            displayCommentsOfVideo(video.getCommentsModel());
            System.out.println("==========================================================================\n\n");
        }
    }

    @GetMapping("/test")
    public void test(){
        commentService.getComments("TYYkFky5pkA");
    }

}
