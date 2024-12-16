package com.akdriss.cvback.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ElementRatingDto {
    private Long id;
    private int rating;
    private String description;
}
