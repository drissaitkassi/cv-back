package com.akdriss.cvback.dtos;

import com.akdriss.cvback.entities.Contact;
import com.akdriss.cvback.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDto {

    private String firstName;
    private String lastName;
    private Gender gender ;
    private String avatar;
    private ContactDto contact;

}
