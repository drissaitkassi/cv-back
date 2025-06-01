package com.akdriss.cvback.mappers;

import com.akdriss.cvback.dtos.SkillDto;
import com.akdriss.cvback.dtos.SkillRefDto;
import com.akdriss.cvback.entities.ElementRating;
import com.akdriss.cvback.entities.Skill;
import com.akdriss.cvback.enums.Type;
import com.akdriss.cvback.repositories.ElementRatingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SkillMapper implements GenericMapper<Skill, SkillDto> {

    private final ElementRatingMapper elementRatingMapper;
    private final ElementRatingRepo elementRatingRepo;
    @Override
    public SkillDto toDto(Skill skill) {
        SkillDto skillDto= new SkillDto();
        skillDto.setId(skill.getId());
        skillDto.setName(skill.getName());
        skillDto.setDescription(skill.getDescription());
        skillDto.setRateable(skill.getRateable());
        //skillDto.setElementRatingDto(elementRatingMapper.toDto(skill.getElementRating()));
        return skillDto;
    }



    @Override
    public Skill toEntity(SkillDto skillDto) {

        Skill skill= new Skill();
        skill.setId(skillDto.getId());
        skill.setName(skillDto.getName());
        skill.setDescription(skillDto.getDescription());
        skill.setRateable(skillDto.getRateable());
        //skill.setElementRating(elementRatingMapper.toEntity(skillDto.getElementRatingDto()));
        return skill;

    }

    @Override
    public List<SkillDto> toListDto(List<Skill> skills) {
        return skills.stream().map(this::toDto).collect(Collectors.toList());
    }

    public SkillRefDto toRefDto(Skill skill) {
        SkillRefDto skillDto= new SkillRefDto();
        skillDto.setId(skill.getId());
        skillDto.setName(skill.getName());
        skillDto.setDescription(skill.getDescription());
        skillDto.setRateable(skill.getRateable());
        List<ElementRating> allByType = elementRatingRepo.findAllByType(Type.OTHER);
        skillDto.setElementRatingDtos(elementRatingMapper.toListDto(allByType));
        //skillDto.setElementRatingDto(elementRatingMapper.toDto(skill.getElementRating()));
        return skillDto;
    }


    public Skill toRefEntity(SkillRefDto skillDto) {

        Skill skill= new Skill();
        skill.setId(skillDto.getId());
        skill.setName(skillDto.getName());
        skill.setDescription(skillDto.getDescription());
        skill.setRateable(skillDto.getRateable());
        return skill;

    }


    public List<SkillRefDto> toRefListDto(List<Skill> skills) {
        return skills.stream().map(this::toRefDto).collect(Collectors.toList());
    }

    @Override
    public List<Skill> toListEntities(List<SkillDto> skillDtos) {
        return skillDtos.stream().map(this::toEntity).collect(Collectors.toList());
    }


    public List<Skill> toRefListEntities(List<SkillRefDto> skillDtos) {
        return skillDtos.stream().map(this::toRefEntity).collect(Collectors.toList());
    }
}
