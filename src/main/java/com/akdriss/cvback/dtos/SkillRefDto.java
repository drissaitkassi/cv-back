package com.akdriss.cvback.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SkillRefDto {

    private Long id;
    private String name;
    private String description;
    private Boolean rateable;
    private List<ElementRatingDto> elementRatingDtos;
}
