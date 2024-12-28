package com.akdriss.cvback.repositories;

import com.akdriss.cvback.entities.Contact;
import com.akdriss.cvback.entities.Degree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends JpaRepository<Contact,Long> {
}
