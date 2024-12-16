package com.akdriss.cvback.mappers;

import com.akdriss.cvback.dtos.IntrestDto;
import com.akdriss.cvback.entities.Intrest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InterestMapper implements GenericMapper<Intrest, IntrestDto> {
    @Override
    public IntrestDto toDto(Intrest intrest) {
        IntrestDto intrestDto=new IntrestDto();
        intrestDto.setId(intrest.getId());
        intrestDto.setName(intrest.getName());
        intrestDto.setDescription(intrest.getDescription());
        intrestDto.setRateable(intrest.getRateable());
        return intrestDto;
    }

    @Override
    public Intrest toEntity(IntrestDto intrestDto) {
        Intrest intrest=new Intrest();
        intrest.setId(intrestDto.getId());
        intrest.setName(intrestDto.getName());
        intrest.setDescription(intrestDto.getDescription());
        intrest.setRateable(intrestDto.getRateable());
        return intrest;

    }

    @Override
    public List<IntrestDto> toListDto(List<Intrest> intrests) {
        return intrests.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<Intrest> toListEntities(List<IntrestDto> intrestDtos) {
        return intrestDtos.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
