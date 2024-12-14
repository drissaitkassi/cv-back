package com.akdriss.cvback.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "other_skill")
public class OtherSkill extends ElementInCategorie{
    @ManyToOne
    @JoinColumn(name = "otherSkills")
    private CV cv;
    @ManyToOne
    @JoinColumn(name = "elementRating")
    private ElementRating elementRating;
}
