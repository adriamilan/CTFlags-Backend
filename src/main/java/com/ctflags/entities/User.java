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
@Table(name="Users")
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="username")
    private String username;
    
    @Column(name="email")
    private String email;
    
    @Column(name="points")
    private Integer points;
    
    @Column(name="role_id")
    private Integer roleId;
    
}