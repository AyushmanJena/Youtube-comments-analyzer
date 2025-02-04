package com.example.demo.Model;

import java.util.ArrayList;

public class VideoModel {
    private String videoId;
    private String title;
    private int views;
    private int likes;
    private ArrayList<CommentsModel> commentsModel;

    public VideoModel() {}

    public VideoModel(String videoId, String title, int views, int likes, ArrayList<CommentsModel> commentsModel) {
        this.videoId = videoId;
        this.title = title;
        this.views = views;
        this.likes = likes;
        this.commentsModel = commentsModel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
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
}
