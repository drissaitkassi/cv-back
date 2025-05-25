package com.akdriss.cvback.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "other_skill_rating")
public class OtherSkillRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private CV cv;
    @ManyToOne
    private OtherSkill otherSkill;
    @ManyToOne
    private ElementRating elementRating;
}
