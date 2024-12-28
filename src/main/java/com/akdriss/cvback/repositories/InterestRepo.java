package com.akdriss.cvback.repositories;

import com.akdriss.cvback.entities.Experience;
import com.akdriss.cvback.entities.Intrest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestRepo extends JpaRepository<Intrest,Long> {
}
