package com.akdriss.cvback.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "skill")
public class Skill extends ElementInCategorie{

    @ManyToOne
    @JoinColumn(name = "skills")
    private CV cv;
    @ManyToOne
    @JoinColumn(name = "elementRating")
    private ElementRating elementRating;
}
