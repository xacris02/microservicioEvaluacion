package com.example.SmokeGameBack.repository;

import com.example.SmokeGameBack.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByUsuarioEmail(String usuarioEmail);
    List<Pedido> findByEstado(String estado);
}