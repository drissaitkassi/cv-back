package com.akdriss.cvback.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LanguageDto {
    private Long id;
    private String name;
    private String description;
    private Boolean rateable = true;
    private ElementRatingDto elementRatingDto;
}
