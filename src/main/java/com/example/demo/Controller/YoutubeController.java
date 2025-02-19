package com.example.demo.Controller;

import com.example.demo.Model.CommentsModel;
import com.example.demo.Model.VideoModel;
import com.example.demo.Service.CommentService;
import com.example.demo.Service.LLMService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class YoutubeController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private LLMService llmService;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/video-result/{videoId}")
    public String homeWithResults(@PathVariable String videoId, Model model){
        ArrayList<CommentsModel> relevantData = commentService.getComments(videoId); // video id
        String result = llmService.getVideoReview(relevantData);
        model.addAttribute("results", result);
        return "index";
    }

    @GetMapping("/playlist-result/{playlistId}")
    public String homeWithResultsPlaylist(@PathVariable String playlistId, Model model){
        ArrayList<VideoModel> videos = commentService.getPlaylistComments(playlistId);
        ArrayList<String> results = llmService.getPlaylistReview(videos);
        model.addAttribute("results", results);
        return "index";
    }

    @PostMapping("/processInputData")
    public String processForm(@RequestParam("link-type")String linkType, @RequestParam("link")String link, HttpServletRequest request){
        System.out.println(link);
        System.out.println(linkType);

    // as of now we are working with playlist Id and videoId directly and not urls

        if(linkType.compareTo("video") == 0){
            return "redirect:/video-result/"+link;
        }else {
            // get results for playlist

            // change return statement redirection as well
            return "redirect:/playlist-result/"+link;
        }


    }


    // extract playlist id and videoId out of the links
//    public String extractVideoId(String link){
//        int i = 0;
//        int j = 0;
//        StringBuilder str = new StringBuilder();
//        while(i < link.length()){
//            if(link.charAt(i) == '='){
//                while(link.charAt(j) != '&'){
//
//                }
//            }
//        }
//    }
}