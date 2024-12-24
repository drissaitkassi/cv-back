package com.akdriss.cvback.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "experience")
public class Experience extends ElementInCategorie{

    private String location;
    @ManyToOne
    @JoinColumn(name = "experiences")
    private CV cv;
}
