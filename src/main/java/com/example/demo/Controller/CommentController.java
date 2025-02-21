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
        VideoModel videoModel = commentService.getVideoOverview(testVideoId);
        videoModel = llmService.getVideoReview(videoModel);
        // testing if the code works
        System.out.println(videoModel.getVideoId());
        System.out.println(videoModel.getTitle());
        System.out.println(videoModel.getThumbnailURL());
        System.out.println(videoModel.getRating());
        System.out.println(videoModel.getCommentsSummary());
        // displayCommentsOfVideo(relevantData);
    }

    @GetMapping("/testplaylist")
    public void getPlaylistDetails(){
        String testPlaylistId = "PLKl5GqiLaCq3XBSy-vM2_CsZ5HQK4vGR_"; // Educational videos playlist
        // String testPlaylistId = "PLHD9dyKTwCNKP-vxlnLNCJxAoTkzLD_GX"; // some random ess videos playlist
        ArrayList<VideoModel> videos = commentService.getPlaylistComments(testPlaylistId);
        videos = llmService.getPlaylistReview(videos);
        // displayCommentsOfPlaylist(videos);
    }

    // with custom video in the url
    @GetMapping("/video/{videoId}")
    public void getVideoCommentDetails(@PathVariable String videoId){
        VideoModel video = commentService.getVideoOverview(videoId); // video id

        if(video.getCommentsModel().isEmpty()){
            System.out.println("Comments could not be retrieved for video : " + videoId);
        }else{
            video = llmService.getVideoReview(video);
        }
        System.out.println(video.getCommentsSummary());
    }

    // with custom playlist in the url
    @GetMapping("/playlist/{playlistId}")
    public void getPlaylistCommentDetails(@PathVariable String playlistId){
        ArrayList<VideoModel> videos = commentService.getPlaylistComments(playlistId);
        videos = llmService.getPlaylistReview(videos);
        for(VideoModel videoModel : videos){
            System.out.println(videoModel.getCommentsSummary());
        }
    }

    public void displayCommentsOfVideo(ArrayList<CommentsModel> commentsModels){
        for(CommentsModel comment : commentsModels){
            System.out.println("comment : " + comment.getText());
            System.out.println("-----------------------------------------------------------------------");
        }
    }

    public void displayCommentsOfPlaylist(ArrayList<VideoModel> videos){
        for(VideoModel video : videos){
            System.out.println("TITLE : " + video.getTitle());
            displayCommentsOfVideo(video.getCommentsModel());
            System.out.println(video.getVideoId());
            System.out.println(video.getTitle());
            System.out.println(video.getThumbnailURL());
            System.out.println(video.getRating());
            System.out.println(video.getCommentsSummary());
            System.out.println("==========================================================================\n\n");
        }
    }

    @GetMapping("/test")
    public void test(){
        commentService.getComments("TYYkFky5pkA");
    }

}
