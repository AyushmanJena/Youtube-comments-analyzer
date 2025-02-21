package com.example.demo.Service;

import com.example.demo.Model.CommentsModel;
import com.example.demo.Model.VideoModel;
import com.example.demo.Response.CommentResponse;
import com.example.demo.Response.PlaylistResponse;

import java.util.ArrayList;

public interface CommentService {
    public CommentResponse getTopCommentsList(String videoId) throws Exception;
    public PlaylistResponse getPlaylistList(String playlistId);
    public ArrayList<CommentsModel> getComments(String videoId);
    public ArrayList<VideoModel> getPlaylistComments(String playlistId);

    public ArrayList<CommentsModel> getCommentWithOrder(String videoId, String order);

    public VideoModel getVideoOverview(String videoId);
}
