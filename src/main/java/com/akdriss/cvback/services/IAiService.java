package com.akdriss.cvback.services;


import com.akdriss.cvback.dtos.CVDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.ai.chat.prompt.PromptTemplate;

public interface IAiService {


    String sendFeedBackPrompt(PromptTemplate promptTemplate , Long  cvid) throws JsonProcessingException;

    CVDto suggestCvPrompt(PromptTemplate pt, Long cvid) throws JsonProcessingException;
}
