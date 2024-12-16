package com.akdriss.cvback.mappers;

import com.akdriss.cvback.dtos.OtherSkillDto;
import com.akdriss.cvback.entities.OtherSkill;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OtherSkillsMapper implements GenericMapper<OtherSkill, OtherSkillDto> {

    private final ElementRatingMapper elementRatingMapper;
    @Override
    public OtherSkillDto toDto(OtherSkill otherSkill) {
        OtherSkillDto otherSkillDto=new OtherSkillDto();
        otherSkillDto.setId(otherSkill.getId());
        otherSkillDto.setName(otherSkill.getName());
        otherSkillDto.setDescription(otherSkill.getDescription());
        otherSkillDto.setRateable(otherSkill.getRateable());
        otherSkillDto.setElementRatingDto(elementRatingMapper.toDto(otherSkill.getElementRating()));
        return otherSkillDto;
    }

    @Override
    public OtherSkill toEntity(OtherSkillDto otherSkillDto) {

        OtherSkill otherSkill=new OtherSkill();
        otherSkill.setId(otherSkillDto.getId());
        otherSkill.setName(otherSkillDto.getName());
        otherSkill.setDescription(otherSkillDto.getDescription());
        otherSkill.setRateable(otherSkillDto.getRateable());
        otherSkill.setElementRating(elementRatingMapper.toEntity(otherSkillDto.getElementRatingDto()));
        return otherSkill;
    }

    @Override
    public List<OtherSkillDto> toListDto(List<OtherSkill> otherSkills) {
        return otherSkills.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<OtherSkill> toListEntities(List<OtherSkillDto> otherSkillDtos) {
        return otherSkillDtos.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
