package com.akdriss.cvback.ressources;

import com.akdriss.cvback.dtos.LanguageDto;
import com.akdriss.cvback.dtos.LanguageRefDto;
import com.akdriss.cvback.services.ILanguageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("v1/lang")
@RestController
public class LanguageController extends AbstractController<LanguageRefDto,ILanguageService> {
    public LanguageController(ILanguageService service) {
        super(service);
    }
}
