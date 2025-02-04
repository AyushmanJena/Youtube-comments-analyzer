package com.example.demo.Model;

public class CommentsModel {

    private String text;
    private int likeCount;
    private String updatedAt;

    public CommentsModel(String text, int likeCount, String updatedAt) {
        this.text = text;
        this.likeCount = likeCount;
        this.updatedAt = updatedAt;
    }

    public CommentsModel() {}

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
