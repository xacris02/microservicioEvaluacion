package com.example.SmokeGameBack.repository;

import com.example.SmokeGameBack.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
}