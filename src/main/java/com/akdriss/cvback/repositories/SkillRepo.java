package com.akdriss.cvback.repositories;

import com.akdriss.cvback.entities.Language;
import com.akdriss.cvback.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepo extends JpaRepository<Skill,Long> {
}
