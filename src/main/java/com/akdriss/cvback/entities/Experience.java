package com.akdriss.cvback.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "experience")
public class Experience extends ElementInCategorie{

    private String location;
    @ManyToOne
    @JoinColumn(name = "cv_id")
    private CV cv;
}
