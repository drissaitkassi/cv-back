package com.akdriss.cvback.mappers;

import com.akdriss.cvback.dtos.SkillDto;
import com.akdriss.cvback.entities.Skill;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SkillMapper implements GenericMapper<Skill, SkillDto> {

    private final ElementRatingMapper elementRatingMapper;

    @Override
    public SkillDto toDto(Skill skill) {
        SkillDto skillDto= new SkillDto();
        skillDto.setId(skill.getId());
        skillDto.setName(skill.getName());
        skillDto.setDescription(skill.getDescription());
        skillDto.setRateable(skill.getRateable());
        skillDto.setElementRatingDto(elementRatingMapper.toDto(skill.getElementRating()));
        return skillDto;
    }

    @Override
    public Skill toEntity(SkillDto skillDto) {

        Skill skill= new Skill();
        skill.setId(skillDto.getId());
        skill.setName(skillDto.getName());
        skill.setDescription(skillDto.getDescription());
        skill.setRateable(skillDto.getRateable());
        skill.setElementRating(elementRatingMapper.toEntity(skillDto.getElementRatingDto()));
        return skill;

    }

    @Override
    public List<SkillDto> toListDto(List<Skill> skills) {
        return skills.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<Skill> toListEntities(List<SkillDto> skillDtos) {
        return skillDtos.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
