package com.akdriss.cvback.services;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.ai.chat.prompt.PromptTemplate;

public interface IAiService {


    String sendFeedBackPrompt(PromptTemplate promptTemplate , Long  cvid) throws JsonProcessingException;

}
