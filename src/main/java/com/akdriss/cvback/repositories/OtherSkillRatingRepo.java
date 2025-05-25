package com.akdriss.cvback.repositories;

import com.akdriss.cvback.entities.OtherSkillRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OtherSkillRatingRepo extends JpaRepository<OtherSkillRating,Long> {

    List<OtherSkillRating> findByCv_Id(Long cvId);
}
