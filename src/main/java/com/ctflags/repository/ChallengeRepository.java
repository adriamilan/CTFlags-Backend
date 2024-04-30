package com.ctflags.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctflags.entities.Challenge;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

}
