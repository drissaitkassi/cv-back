package com.akdriss.cvback.ressources;


import com.akdriss.cvback.dtos.CVDto;
import com.akdriss.cvback.services.IAiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("ai")
@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
public class AiController {



   private final IAiService iAiService;

   @Value("classpath:/prompts/cvfeedback.st")
   private Resource feedBackPromptTemplate;

    @Value("classpath:/prompts/aiSuggestedCV.st")
   private Resource aiCVSuggestionPromptTemplate;
    @GetMapping("ask")
    public ResponseEntity<String> feedBack(@RequestParam Long  cvId) throws JsonProcessingException {
        PromptTemplate pt= new PromptTemplate(feedBackPromptTemplate);
        return ResponseEntity.ok(iAiService.sendFeedBackPrompt(pt,cvId));


    }

    @GetMapping("suggest")
    public CVDto suggestCv(@RequestParam Long  cvId){


        return null;
    }


}
