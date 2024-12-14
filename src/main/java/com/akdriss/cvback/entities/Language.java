package com.akdriss.cvback.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "language")
public class Language extends ElementInCategorie{
    @ManyToOne
    @JoinColumn(name = "languages")
    private CV cv;
    @ManyToOne
    @JoinColumn(name = "elementRating")
    private ElementRating elementRating;
}
