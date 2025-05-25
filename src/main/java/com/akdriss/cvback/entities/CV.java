package com.akdriss.cvback.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Entity
@Getter
@Setter
@ToString
@Table(name = "cv")
public class CV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String offer;
    @OneToOne
    @JoinColumn(name = "candidate_id",referencedColumnName = "id")
    private User candidate;

    @OneToMany(mappedBy = "cv")
    private List<Degree> degrees;
    @OneToMany(mappedBy = "cv")
    private List<Intrest> intrests;
    @OneToMany(mappedBy = "cv")
    private List<Experience> experiences;

    @OneToMany(fetch = FetchType.EAGER)
    private List<LanguageRating> languageRatingList;
    @OneToMany
    private List<SkillRating> skillRatingList;
    @OneToMany
    private List<OtherSkillRating> otherSkillRatingList;

}
