package com.akdriss.cvback.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "lang_rating")
public class LanguageRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private CV cv;
    @ManyToOne
    private Language language;
    @ManyToOne
    private ElementRating elementRating;



}
