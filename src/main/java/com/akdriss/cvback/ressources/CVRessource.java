package com.akdriss.cvback.ressources;


import com.akdriss.cvback.dtos.CVDto;
import com.akdriss.cvback.services.ICVService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("v1/cv")
@RestController
@RequiredArgsConstructor
public class CVRessource {

    private ICVService icvService;

    @GetMapping
    public List<CVDto> getAll(){
        return icvService.getAll();
    }
    @GetMapping("/{id}")
    public CVDto getById(@PathVariable(name = "id") Long id){
        return icvService.getById(id);
    }

    @PostMapping
    public CVDto save(@RequestBody CVDto cvDto){
        return icvService.save(cvDto);
    }

    @PutMapping
    public CVDto update(@RequestBody CVDto cvDto){
        return icvService.update(cvDto);
    }

}
