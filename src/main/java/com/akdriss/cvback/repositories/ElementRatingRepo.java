package com.akdriss.cvback.repositories;

import com.akdriss.cvback.entities.ElementRating;
import com.akdriss.cvback.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElementRatingRepo extends JpaRepository<ElementRating,Long> {
    List<ElementRating> findAllByType(Type type);
}
