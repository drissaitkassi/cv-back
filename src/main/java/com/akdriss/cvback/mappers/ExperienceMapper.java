package com.akdriss.cvback.mappers;

import com.akdriss.cvback.dtos.ExperienceDto;
import com.akdriss.cvback.entities.Experience;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExperienceMapper implements GenericMapper<Experience, ExperienceDto> {
    @Override
    public ExperienceDto toDto(Experience experience) {
        ExperienceDto experienceDto= new ExperienceDto();
        experienceDto.setRateable(experience.getRateable());
        experienceDto.setId(experience.getId());
        experienceDto.setDescription(experience.getDescription());
        experienceDto.setLocation(experience.getLocation());
        experienceDto.setName(experience.getName());
        return experienceDto;
    }

    @Override
    public Experience toEntity(ExperienceDto experienceDto) {
        Experience experience=new Experience();
        experience.setRateable(experienceDto.getRateable());
        experience.setName(experienceDto.getName());
        experience.setId(experienceDto.getId());
        experience.setDescription(experienceDto.getDescription());
        experience.setLocation(experienceDto.getLocation());
        return experience;
    }

    @Override
    public List<ExperienceDto> toListDto(List<Experience> experiences) {
        return experiences.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<Experience> toListEntities(List<ExperienceDto> experienceDtos) {
        return experienceDtos.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
