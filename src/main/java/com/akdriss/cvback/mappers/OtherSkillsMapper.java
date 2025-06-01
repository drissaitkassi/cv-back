package com.akdriss.cvback.mappers;

import com.akdriss.cvback.dtos.OtherSkillDto;
import com.akdriss.cvback.dtos.OtherSkillRefDto;
import com.akdriss.cvback.entities.ElementRating;
import com.akdriss.cvback.entities.OtherSkill;
import com.akdriss.cvback.enums.Type;
import com.akdriss.cvback.repositories.ElementRatingRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class OtherSkillsMapper implements GenericMapper<OtherSkill, OtherSkillDto> {

    private final ElementRatingMapper elementRatingMapper;
    private final ElementRatingRepo elementRatingRepo;

    @Override
    public OtherSkillDto toDto(OtherSkill otherSkill) {
        OtherSkillDto otherSkillDto=new OtherSkillDto();
        otherSkillDto.setId(otherSkill.getId());
        otherSkillDto.setName(otherSkill.getName());
        otherSkillDto.setDescription(otherSkill.getDescription());
        otherSkillDto.setRateable(otherSkill.getRateable());
        //otherSkillDto.setElementRatingDto(elementRatingMapper.toDto(otherSkill.getElementRating()));
        return otherSkillDto;
    }

    @Override
    public OtherSkill toEntity(OtherSkillDto otherSkillDto) {

        OtherSkill otherSkill=new OtherSkill();
        otherSkill.setId(otherSkillDto.getId());
        otherSkill.setName(otherSkillDto.getName());
        otherSkill.setDescription(otherSkillDto.getDescription());
        otherSkill.setRateable(otherSkillDto.getRateable());
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

    public OtherSkillRefDto toRefDto(OtherSkill otherSkill) {
        OtherSkillRefDto otherSkillRefDto = new OtherSkillRefDto();
        otherSkillRefDto.setId(otherSkill.getId());
        otherSkillRefDto.setName(otherSkill.getName());
        otherSkillRefDto.setDescription(otherSkill.getDescription());
        otherSkillRefDto.setRateable(otherSkill.getRateable());
        List<ElementRating> allByType = elementRatingRepo.findAllByType(Type.OTHER);
        otherSkillRefDto.setElementRatingDtos(elementRatingMapper.toListDto(allByType));
        return otherSkillRefDto;
    }


    public OtherSkill toRefEntity(OtherSkillRefDto skillRefDto) {
        OtherSkill otherSkill = new OtherSkill();
        otherSkill.setId(skillRefDto.getId());
        otherSkill.setName(skillRefDto.getName());
        otherSkill.setDescription(skillRefDto.getDescription());
        otherSkill.setRateable(skillRefDto.getRateable());

        return otherSkill;
    }
    public List<OtherSkillRefDto> toRefListDto(List<OtherSkill> all) {
        return all.stream().map(this::toRefDto).toList();
    }
}
