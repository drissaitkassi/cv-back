package com.akdriss.cvback.repositories;

import com.akdriss.cvback.entities.LanguageRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LanguageRatingRepo extends JpaRepository<LanguageRating,Long> {


    List<LanguageRating> findByCv_Id(Long cvId);
}
