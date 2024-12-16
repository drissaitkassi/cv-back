package com.akdriss.cvback.mappers;

import com.akdriss.cvback.dtos.ElementRatingDto;
import com.akdriss.cvback.entities.ElementRating;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ElementRatingMapper implements GenericMapper<ElementRating, ElementRatingDto>{
    @Override
    public ElementRatingDto toDto(ElementRating elementRating) {
        ElementRatingDto elementRatingDto=new ElementRatingDto();
        elementRatingDto.setDescription(elementRating.getDescription());
        elementRatingDto.setRating(elementRating.getRating());
        elementRatingDto.setId(elementRating.getId());
        return elementRatingDto;
    }

    @Override
    public ElementRating toEntity(ElementRatingDto elementRatingDto) {
        ElementRating elementRating=new ElementRating();
        elementRating.setDescription(elementRatingDto.getDescription());
        elementRating.setRating(elementRatingDto.getRating());
        elementRating.setId(elementRatingDto.getId());
        return elementRating;

    }

    @Override
    public List<ElementRatingDto> toListDto(List<ElementRating> elementRatings) {
        return null;
    }

    @Override
    public List<ElementRating> toListEntities(List<ElementRatingDto> elementRatingDtos) {
        return null;
    }
}
