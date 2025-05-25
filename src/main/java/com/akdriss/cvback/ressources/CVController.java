package com.akdriss.cvback.ressources;

import com.akdriss.cvback.dtos.CVDto;
import com.akdriss.cvback.services.ICVService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("v1/cv")
@RestController
public class CVController extends AbstractController <CVDto, ICVService> {
    public CVController(ICVService service) {
        super(service);
    }
}
