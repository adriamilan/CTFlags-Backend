package com.ctflags.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctflags.entities.Solution;

@Repository
public interface SolutionRepository extends JpaRepository<Solution, Long> {

}
