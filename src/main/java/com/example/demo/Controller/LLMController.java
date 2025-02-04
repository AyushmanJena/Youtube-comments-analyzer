package com.example.demo.Controller;

import com.example.demo.Response.PromptResponse;
import com.example.demo.Service.LLMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class LLMController {
    @Autowired
    private LLMService llmService;

    @GetMapping("/llmtest")
    public void test(){

        String prePrompt = "Here are a few comments from a youtube video titled 'Linked List Interview Questions -" +
                " Google, Facebook, Amazon, Microsoft', give a summary of the comments in short and tell me if the video is worth watching," +
                " ignore the filler comments just focus on valuable comments and give straight answer if the video is worth watching or not: ";
        String comments =
                "comment : thanku\n" +
                "Like count : 0\n" +
                "Updated At : 2025-01-24T21:39:49Z\n" +
                "-----------------------------------------------------------------------\n" +
                "comment : never thought LinkedList would be so easy.... thanks Kunal!!\n" +
                "Like count : 0\n" +
                "Updated At : 2025-01-19T13:17:52Z\n" +
                "-----------------------------------------------------------------------\n" +
                "comment : no one on the entire YouTube can teach me how to reverse a linked list with full of satisfaction none other than kunal tnx brother\n" +
                "Like count : 0\n" +
                "Updated At : 2025-01-16T17:03:04Z\n" +
                "-----------------------------------------------------------------------\n" +
                "comment : 2:53:22 bro I am in shock with this , I think you will write more big code for this question, but bro you made laugh after watching the solution, questions are different but their approach are connected to each other \uD83D\uDE02\n" +
                "Like count : 0\n" +
                "Updated At : 2025-01-16T12:31:25Z\n" +
                "-----------------------------------------------------------------------\n" +
                "comment : great\n" +
                "Like count : 0\n" +
                "Updated At : 2025-01-09T19:44:34Z\n" +
                "-----------------------------------------------------------------------\n" +
                "comment : I really feel a lot of wastage of time when your take time in explaining the same kind of problem again...\n" +
                "Like count : 0\n" +
                "Updated At : 2025-01-08T07:37:13Z\n" +
                "-----------------------------------------------------------------------\n" +
                "comment : 2:21:40 (palindrome) for odd no of elements I think one element would left from headsecond right while comparing then how it's return true?? Can some one explain please\n" +
                "Like count : 0\n" +
                "Updated At : 2025-01-03T15:46:52Z\n" +
                "-----------------------------------------------------------------------\n" +
                "comment : Worth please watch it\n" +
                "Like count : 0\n" +
                "Updated At : 2025-01-03T07:23:28Z\n" +
                "-----------------------------------------------------------------------\n" +
                "comment : at 1:19:45  of video , didn't anybody notice 2^2+9^2 = 85 but he wrote 89?\n" +
                "not pointing out the mistake , because i was not the show , but i dont see anyone telling that!\n" +
                "this man is god ,I myself made mistakes so many time during creation of LL , but i see no one is trying out maybe hence its not here in comments...\n" +
                "or am I the wrong one?\n" +
                "Like count : 0\n" +
                "Updated At : 2025-01-02T16:38:46Z\n" +
                "-----------------------------------------------------------------------";
        String prompt = prePrompt + comments;
        String result = llmService.test(prompt);
        System.out.println(result);
    }
}
