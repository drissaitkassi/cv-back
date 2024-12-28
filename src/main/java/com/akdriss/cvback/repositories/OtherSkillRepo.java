package com.akdriss.cvback.repositories;

import com.akdriss.cvback.entities.Language;
import com.akdriss.cvback.entities.OtherSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherSkillRepo extends JpaRepository<OtherSkill,Long> {
}
