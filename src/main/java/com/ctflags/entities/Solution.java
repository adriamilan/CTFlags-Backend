package com.ctflags.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="Solutions")
public class Solution {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="user_id")
    Integer user_id;
    
    @Column(name="challenge_id")
    Integer challenge_id;
    
    @Column(name="solution")
    String solution;
    
    @Column(name="language")
    String language;
}