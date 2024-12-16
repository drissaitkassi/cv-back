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
    private Long id;
    private String  offer;
    private CandidateDto candidate;
    private List<LanguageDto> languages;
    private List<ExperienceDto> experiences;
    private List<SkillDto> skills;
    private List<DegreeDto> degrees;
    private List<IntrestDto> intrests;
    private List<OtherSkillDto> otherSkills;
}
