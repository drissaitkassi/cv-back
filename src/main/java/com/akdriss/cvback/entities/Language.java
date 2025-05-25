package com.akdriss.cvback.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "language")
@AllArgsConstructor
@NoArgsConstructor
public class Language extends ElementInCategorie{

    @OneToMany
    private List<LanguageRating> languageRatingList;
}
