package com.example.SmokeGameBack.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre; 

    @Column(nullable = false, unique = true)
    private String email; 

    @Column(nullable = false)
    private String password; 

    private LocalDate fechaNacimiento; 

    private String rol; 

    private Integer descuento; 
}