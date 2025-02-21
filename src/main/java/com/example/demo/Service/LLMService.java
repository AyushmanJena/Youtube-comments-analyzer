package com.example.demo.Service;

import com.example.demo.Model.CommentsModel;
import com.example.demo.Model.VideoModel;
import com.example.demo.Response.PromptResponse;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

public interface LLMService {
    public String test(String prompt);

    public String getVideoReview(ArrayList<CommentsModel> comments);

    public String getResultsFromLLM(String input);

    public ArrayList<VideoModel> getPlaylistReview(ArrayList<VideoModel> videos);

    public VideoModel getVideoReview(VideoModel video);
}
