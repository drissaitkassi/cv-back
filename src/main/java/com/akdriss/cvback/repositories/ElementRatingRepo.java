package com.akdriss.cvback.repositories;

import com.akdriss.cvback.entities.ElementRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementRatingRepo extends JpaRepository<ElementRating,Long> {
}
