package com.example.demo.Model;

import java.util.ArrayList;

public class VideoModel {
    private String videoId;
    private String title;
    private ArrayList<CommentsModel> commentsModel;

    // added newly
    private String thumbnailURL;
    private int rating;
    private String commentsSummary;

    public VideoModel() {}

    public VideoModel(String videoId, String title, ArrayList<CommentsModel> commentsModel, String thumbnailURL) {
        this.videoId = videoId;
        this.title = title;
        this.commentsModel = commentsModel;
        this.thumbnailURL = thumbnailURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<CommentsModel> getCommentsModel() {
        return commentsModel;
    }

    public void setCommentsModel(ArrayList<CommentsModel> commentsModel) {
        this.commentsModel = commentsModel;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getCommentsSummary() {
        return commentsSummary;
    }

    public void setCommentsSummary(String commentsSummary) {
        this.commentsSummary = commentsSummary;
    }
}
