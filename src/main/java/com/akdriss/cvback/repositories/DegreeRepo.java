package com.akdriss.cvback.repositories;

import com.akdriss.cvback.entities.Degree;
import com.akdriss.cvback.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DegreeRepo extends JpaRepository<Degree,Long> {
}
