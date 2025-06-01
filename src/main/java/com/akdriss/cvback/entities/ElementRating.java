package com.akdriss.cvback.entities;

import com.akdriss.cvback.enums.Type;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "element_rating")
public class ElementRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int rating;
    private String description;
    @Enumerated(value = EnumType.STRING)
    private Type type;

    @OneToMany
    private List<SkillRating> skillRatings;
    @OneToMany
    private List<OtherSkillRating> otherSkillRatings;
    @OneToMany
    private List<LanguageRating> languageRatingList;


}
