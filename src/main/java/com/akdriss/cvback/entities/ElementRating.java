package com.akdriss.cvback.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


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
    @OneToMany(mappedBy = "elementRating")
    private List<Language> languages;
    @OneToMany(mappedBy = "elementRating")
    private List<Skill> skills;
    @OneToMany(mappedBy = "elementRating")
    private List<OtherSkill> otherSkills;


}
