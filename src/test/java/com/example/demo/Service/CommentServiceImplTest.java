package com.example.demo.Service;

import com.example.demo.Model.CommentsModel;
import com.example.demo.Model.VideoModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class CommentServiceImplTest {
    @Autowired
    private CommentService commentService;

    // VIDEO TESTS

    @Test
    public void testGetCommentsIsNotNull(){ // video with comments should not return null
        String string = "70tx7KcMROc";
        Assertions.assertNotNull(commentService.getComments(string).get(0));
    }

    @Test
    public void testGetCommentsNull(){ // video with comments turned off should return empty list
        String string = "oDplLI2LtsU";
        ArrayList<CommentsModel> commentsModels = new ArrayList<>();
        Assertions.assertEquals(commentsModels, commentService.getComments(string));
    }

    @Test
    public void testGetCommentsNullVideo(){ // for an invalid videoId
        String string = "oDplLI2LJsU";
        ArrayList<CommentsModel> commentsModels = new ArrayList<>();
        Assertions.assertEquals(commentsModels, commentService.getComments(string));
    }

    @Test
    public void testCommentsContent(){ //compare the values of comments with a video less than 10 comments
        String videoId = "qSL9CycbIB8";
        ArrayList<CommentsModel> comments = commentService.getComments(videoId);
        HashSet<String> obtainedComments = new HashSet<>();
        for(CommentsModel comment : comments){
            obtainedComments.add(comment.getText());
        }

        HashSet<String> preDefinedComments = new HashSet<>(); // we know the comments on the video
        preDefinedComments.add("Big fan brother");
        preDefinedComments.add("❤\uFE0F\u200D\uD83D\uDD25❤\uFE0F\u200D\uD83D\uDD25❤\uFE0F\u200D\uD83D\uDD25");
        preDefinedComments.add("Full support bhai ❤");

        Assertions.assertEquals(preDefinedComments, obtainedComments);
    }


    // PLAYLIST TESTS

    @Test
    public void TestGetPlaylistComments(){ // playlist with videos that exist
        String playlistId = "PLHD9dyKTwCNKP-vxlnLNCJxAoTkzLD_GX";
        ArrayList<VideoModel> videos = commentService.getPlaylistComments(playlistId);
        Assertions.assertNotNull(videos.get(0));
    }

    @Test
    public void TestGetPlaylistCommentsInvalidId(){ // playlist with invalid playlistID
        String playlistId = "PLHD9dyKTwCNKPadfadflnLNCJxAoTkzLD_GX"; // invalid playlist id
        ArrayList<VideoModel> videos = new ArrayList<>();
        Assertions.assertEquals(videos, commentService.getPlaylistComments(playlistId));
    }
}
