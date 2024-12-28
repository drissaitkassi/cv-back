package com.akdriss.cvback.repositories;

import com.akdriss.cvback.entities.Degree;
import com.akdriss.cvback.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
}
