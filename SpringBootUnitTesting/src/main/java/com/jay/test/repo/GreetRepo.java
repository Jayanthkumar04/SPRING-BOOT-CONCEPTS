package com.jay.test.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jay.test.entity.Greet;

public interface GreetRepo extends JpaRepository<Greet, UUID>{

}
