package com.akdriss.cvback.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "other_skill")
public class OtherSkill extends ElementInCategorie{

    @OneToMany
    private List<OtherSkillRating> otherSkillRatingList;
}
