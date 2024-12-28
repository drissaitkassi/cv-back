package com.akdriss.cvback.repositories;

import com.akdriss.cvback.entities.Experience;
import com.akdriss.cvback.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepo extends JpaRepository<Experience,Long> {
}
