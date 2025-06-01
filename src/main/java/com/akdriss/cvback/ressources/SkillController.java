package com.akdriss.cvback.ressources;

import com.akdriss.cvback.dtos.SkillRefDto;
import com.akdriss.cvback.services.ISkillService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("v1/skill")
@RestController
public class SkillController extends AbstractController<SkillRefDto, ISkillService> {
    public SkillController(ISkillService service) {
        super(service);
    }
}
