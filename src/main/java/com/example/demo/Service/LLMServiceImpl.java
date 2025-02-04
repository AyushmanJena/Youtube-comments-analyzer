package com.example.demo.Service;

import com.example.demo.Model.CommentsModel;
import com.example.demo.Model.VideoModel;
import com.example.demo.Response.PromptRequest;
import com.example.demo.Response.PromptResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LLMServiceImpl implements LLMService{
    private final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent?key=";

    @Autowired
    private RestTemplate restTemplate;

    @Value("${gemini.api.key}")
    private String api_key;

    @Override
    public String getResultsFromLLM(String input){ // this input includes comments of a single video
        String api = API_URL + api_key;
        PromptRequest.Part part = new PromptRequest.Part();
        part.setText(input);
        PromptRequest.Content content = new PromptRequest.Content();
        content.setParts(List.of(part));

        PromptRequest body = new PromptRequest();
        body.setContents(List.of(content));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Request Entity creation
        HttpEntity<PromptRequest> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<PromptResponse> response = restTemplate.exchange(api, HttpMethod.POST, requestEntity, PromptResponse.class);

        return response.getBody().getCandidates().get(0).getContent().getParts().get(0).getText();
    }

    @Override
    public String getVideoReview(ArrayList<CommentsModel> comments) {
        String prePrompt = "Here is a list of comments from a video, go through the comments " +
                "in short list if any topics are not explained well or missed " +
                "and also if the video should be skipped or not ?" + "also rate the video according to the comments on a scale of 1 to 5. "
                + "Answer within 3-4 lines.";

        StringBuilder commentsStr = new StringBuilder();

        for(CommentsModel comment : comments){
            commentsStr.append(comment.getText()+",");
        }

        String prompt = prePrompt + commentsStr;

        return getResultsFromLLM(prompt);
    }

    @Override
    public ArrayList<String> getPlaylistReview(ArrayList<VideoModel> videos){
        ArrayList<String> llmResponsesForPlaylist = new ArrayList<>();
        for(VideoModel video : videos){
            llmResponsesForPlaylist.add(getVideoReview(video.getCommentsModel()));
        }
        return llmResponsesForPlaylist;
    }


    @Override
    public String test(String prompt) {
        String api = API_URL + api_key;

        PromptRequest.Part part = new PromptRequest.Part();
        part.setText(prompt);

        PromptRequest.Content content = new PromptRequest.Content();
        content.setParts(List.of(part));

        PromptRequest body = new PromptRequest();
        body.setContents(List.of(content));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Request Entity creation
        HttpEntity<PromptRequest> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<PromptResponse> response = restTemplate.exchange(api, HttpMethod.POST, requestEntity, PromptResponse.class);

        return response.getBody().getCandidates().get(0).getContent().getParts().get(0).getText();
    }
}
