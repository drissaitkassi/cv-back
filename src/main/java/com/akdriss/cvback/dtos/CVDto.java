package com.akdriss.cvback.dtos;
import com.akdriss.cvback.entities.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CVDto {
    private Offer offer;
    private User candidate;
    private List<Language> languages;
    private List<Experience> experiences;
    private List<Skill> skills;
    private List<Degree> degrees;
    private List<Intrest> intrests;
    private List<OtherSkill> otherSkills;
}
