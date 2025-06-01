package com.akdriss.cvback.services;

import com.akdriss.cvback.dtos.SkillRefDto;

import java.util.List;

public interface ISkillService extends GenericService<SkillRefDto>{
    List<SkillRefDto> getAll();
    SkillRefDto getById(Long id);

    SkillRefDto save(SkillRefDto cvDto);


    SkillRefDto update(SkillRefDto cvDto);
}
