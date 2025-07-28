package com.akdriss.cvback.services;

import com.akdriss.cvback.dtos.CVDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service

public class AiServiceImpl implements IAiService{

    private final ChatClient chatClient;
    private final ICVService icvService;

    public AiServiceImpl(ChatClient.Builder builder ,ICVService icvService) {
        this.chatClient = builder.build();
        this.icvService=icvService;
    }

    @Override
    public String sendFeedBackPrompt(PromptTemplate pt, Long cvid) throws JsonProcessingException {

        CVDto byId = icvService.getById(cvid);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(byId);
        Prompt prompt =pt.create(Map.of("context",s));

        String content = chatClient.prompt(prompt).call().content();
        System.out.println( "============ AI RESPONSE =============");

        System.out.println(content);

        return content;
    }

}
