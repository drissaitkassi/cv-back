package com.akdriss.cvback.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "interest")
public class Intrest extends ElementInCategorie{
    @ManyToOne
    @JoinColumn(name = "cv_id")
    private CV cv;
}
