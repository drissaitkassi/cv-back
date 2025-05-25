package com.akdriss.cvback.mappers;

import com.akdriss.cvback.dtos.DegreeDto;
import com.akdriss.cvback.entities.Degree;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DegreeMapper implements GenericMapper<Degree, DegreeDto> {
    @Override
    public DegreeDto toDto(Degree degree) {
        DegreeDto degreeDto=new DegreeDto();
        degreeDto.setId(degree.getId());
        degreeDto.setName(degree.getName());
        degreeDto.setDescription(degree.getDescription());
        degreeDto.setLocation(degree.getLocation());
        degreeDto.setRateable(degree.getRateable());
        return degreeDto;
    }

    @Override
    public Degree toEntity(DegreeDto degreeDto) {

        Degree degree=new Degree();
        degree.setId(degreeDto.getId());
        degree.setName(degreeDto.getName());
        degree.setDescription(degreeDto.getDescription());
        degree.setLocation(degreeDto.getLocation());
        degree.setRateable(degreeDto.getRateable());
        return degree;
    }

    @Override
    public List<DegreeDto> toListDto(List<Degree> degrees) {
        return degrees.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<Degree> toListEntities(List<DegreeDto> degreeDtos) {
        return degreeDtos.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
