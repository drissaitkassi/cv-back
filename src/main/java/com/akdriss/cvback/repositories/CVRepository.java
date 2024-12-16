package com.akdriss.cvback.repositories;

import com.akdriss.cvback.entities.CV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVRepository extends JpaRepository<CV,Long> {
}
