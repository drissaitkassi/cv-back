package com.akdriss.cvback.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "skill_rating")
public class SkillRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private CV cv;
    @ManyToOne
    private Skill skill;
    @ManyToOne
    private ElementRating elementRating;
}
