package com.akdriss.cvback.services;

import com.akdriss.cvback.dtos.SkillRefDto;
import com.akdriss.cvback.mappers.SkillMapper;
import com.akdriss.cvback.repositories.SkillRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ISkillServiceImpl implements ISkillService {

    private final SkillRepo skillRepo;
    private final SkillMapper skillMapper;


    @Override
    public List<SkillRefDto> getAll() {
        return skillMapper.toRefListDto(skillRepo.findAll());
    }

    @Override
    public SkillRefDto getById(Long id) {
        return skillMapper.toRefDto(skillRepo.findById(id).orElseThrow(()->new EntityNotFoundException("Skill with id "+id+" not found ")));
    }

    @Override
    public SkillRefDto save(SkillRefDto skillRefDto) {
        return skillMapper.toRefDto(skillRepo.save(skillMapper.toRefEntity(skillRefDto)));
    }

    @Override
    public SkillRefDto update(SkillRefDto skillRefDto) {
        if (skillRefDto.getId() == null)
            throw new RuntimeException("cannot update skill with Id null ");
        return skillMapper.toRefDto(skillRepo.save(skillMapper.toRefEntity(skillRefDto)));
    }
}
