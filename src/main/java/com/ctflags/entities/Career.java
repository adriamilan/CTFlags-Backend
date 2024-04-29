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
@Table(name="Careers")
public class Career {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="name")
    String name;
    
    @Column(name="description")
    String description;
    
    @Column(name="company_name")
    String company_name;
    
    @Column(name="role_id")
    Integer role_id;
    
    @Column(name="challenge_id")
    Integer challenge_id;
}
