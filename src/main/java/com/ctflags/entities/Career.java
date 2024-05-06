package com.ctflags.entities;

import java.sql.Date;

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
    
    @Column(name="fecha")
    private Date fecha;
    
    @Column(name="provincia")
    private String provincia;
    
    @Column(name="teletrabajo")
    private boolean teletrabajo;
    
    @Column(name="presencial")
    private boolean presencial;
    
    @Column(name="hibrido")
    private boolean hibrido;
    
    @Column(name="salario")
    private int salario;
    
    @Column(name="experiencia")
    private int experiencia;
    
    @Column(name="jornada_laboral")
    private String jornada_laboral;
    
    @Column(name="tipo_contrato")
    private String tipo_contrato;
    
    @Column(name="role_id")
    Integer role_id;
    
    @Column(name="challenge_id")
    Integer challenge_id;
}
