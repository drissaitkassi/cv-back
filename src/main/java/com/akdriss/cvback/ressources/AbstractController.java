package com.akdriss.cvback.ressources;

import com.akdriss.cvback.dtos.CVDto;
import com.akdriss.cvback.services.GenericService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *

 * @param <D> Dto
 * @param <S> Service
 */

@RequiredArgsConstructor
public abstract class AbstractController <D,S extends GenericService<D>> {

    private final S service;

    @GetMapping
    public List<D> getAll(){return service.getAll();}
    @GetMapping("/{id}")
    public D getById(@PathVariable(name = "id") Long id){
        return service.getById(id);
    }

    @PostMapping
    public D save(@RequestBody D d){
        return service.save(d);
    }
    @PutMapping
    public D update(@RequestBody D d){
        return service.update(d);
    }


}
