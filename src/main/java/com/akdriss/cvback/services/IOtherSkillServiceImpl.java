package com.akdriss.cvback.services;

import com.akdriss.cvback.dtos.OtherSkillRefDto;
import com.akdriss.cvback.dtos.SkillRefDto;
import com.akdriss.cvback.mappers.OtherSkillsMapper;
import com.akdriss.cvback.mappers.SkillMapper;
import com.akdriss.cvback.repositories.OtherSkillRepo;
import com.akdriss.cvback.repositories.SkillRepo;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IOtherSkillServiceImpl implements IOtherSkillService {

    private final OtherSkillRepo skillRepo;
    private final OtherSkillsMapper skillMapper;


    @Override
    public List<OtherSkillRefDto> getAll() {
        return skillMapper.toRefListDto(skillRepo.findAll());
    }

    @Override
    public OtherSkillRefDto getById(Long id) {
        return skillMapper.toRefDto(skillRepo.findById(id).orElseThrow(()->new EntityNotFoundException("Other Skill with id "+id+" not found ")));
    }

    @Override
    public OtherSkillRefDto save(OtherSkillRefDto skillRefDto) {
        return skillMapper.toRefDto(skillRepo.save(skillMapper.toRefEntity(skillRefDto)));
    }

    @Override
    public OtherSkillRefDto update(OtherSkillRefDto skillRefDto) {
        if (skillRefDto.getId() == null)
            throw new RuntimeException("cannot update Other skill with Id null ");
        return skillMapper.toRefDto(skillRepo.save(skillMapper.toRefEntity(skillRefDto)));
    }
}
