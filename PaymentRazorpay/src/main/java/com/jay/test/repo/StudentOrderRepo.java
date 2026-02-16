package com.jay.test.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jay.test.dto.StudentOrder;

public interface StudentOrderRepo extends JpaRepository<StudentOrder, Integer>{

}
