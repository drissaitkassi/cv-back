package com.akdriss.cvback.dtos;


import com.akdriss.cvback.entities.LanguageRating;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LanguageRefDto {

    private Long id;
    private String name;
    private String description;
    private Boolean rateable = true;
    private List<ElementRatingDto> elementRatingDtos;
}
