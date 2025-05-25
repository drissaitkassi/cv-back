package com.akdriss.cvback.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Entity
@Getter
@Setter
@Table(name = "degree")
public class Degree extends ElementInCategorie{
    private String location;
    @ManyToOne
    @JoinColumn(name = "cv_id")
    private CV cv;


}
