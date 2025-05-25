package com.akdriss.cvback.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "skill")
public class Skill extends ElementInCategorie{

    @OneToMany
    private List<SkillRating> skillRatingList;
}
