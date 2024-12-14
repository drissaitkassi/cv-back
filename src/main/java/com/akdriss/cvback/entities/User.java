package com.akdriss.cvback.entities;

import com.akdriss.cvback.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Gender gender ;
    @OneToOne
    private Contact contact;
    @OneToMany(mappedBy = "candidate")
    private List<CV> cvs;
    @OneToMany
    private List<Role> userRoles;

}
