package com.akdriss.cvback.repositories;

import com.akdriss.cvback.entities.SkillRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRatingRepo extends JpaRepository<SkillRating,Long> {


    List<SkillRating> findByCv_Id(Long cvId);
}


