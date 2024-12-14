package com.akdriss.cvback.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "cv")
public class CV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Offer offer;
    @ManyToOne
    @JoinColumn(name = "candidate")
    private User candidate;
    @OneToMany
    private List<Language> languages;
    @OneToMany
    private List<Experience> experiences;
    @OneToMany
    private List<Skill> skills;
    @OneToMany
    private List<Degree> degrees;
    @OneToMany
    private List<Intrest> intrests;
    @OneToMany
    private List<OtherSkill> otherSkills;

}
