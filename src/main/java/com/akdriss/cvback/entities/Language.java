package com.akdriss.cvback.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "language")
@AllArgsConstructor
@NoArgsConstructor
public class Language extends ElementInCategorie{
    @ManyToOne
    @JoinColumn(name = "languages")
    private CV cv;
    @ManyToOne
    @JoinColumn(name = "elementRating")
    private ElementRating elementRating;
}
