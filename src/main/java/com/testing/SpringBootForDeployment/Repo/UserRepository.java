package com.testing.SpringBootForDeployment.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.testing.SpringBootForDeployment.Model.*;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

