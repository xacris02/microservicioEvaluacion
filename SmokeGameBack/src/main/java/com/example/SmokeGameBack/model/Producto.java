package com.example.SmokeGameBack.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre; 

    @Column(length = 1000) 
    private String descripcion; 

    private Double precio; 

    private String categoria; 

    private String imagenUrl; 

    private Boolean esServicio; 
    
    private Integer stock;
}