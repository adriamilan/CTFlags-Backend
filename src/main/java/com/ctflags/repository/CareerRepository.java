package com.ctflags.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctflags.entities.Career;

@Repository
public interface CareerRepository extends JpaRepository<Career, Long> {

}
