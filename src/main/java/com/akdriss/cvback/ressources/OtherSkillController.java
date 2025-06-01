package com.akdriss.cvback.ressources;

import com.akdriss.cvback.dtos.OtherSkillRefDto;
import com.akdriss.cvback.dtos.SkillRefDto;
import com.akdriss.cvback.services.IOtherSkillService;
import com.akdriss.cvback.services.ISkillService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("v1/other-skill")
@RestController
public class OtherSkillController extends AbstractController<OtherSkillRefDto, IOtherSkillService> {
    public OtherSkillController(IOtherSkillService service) {
        super(service);
    }
}
