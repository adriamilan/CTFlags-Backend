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
@Table(name="Challenges")
public class Challenge {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="name")
    String name;
    
    @Column(name="description")
    String description;
    
    @Column(name="flag")
    String flag;
    
    @Column(name="points")
    Integer Points;
    
    @Column(name="difficulty")
    String difficulty;
}
