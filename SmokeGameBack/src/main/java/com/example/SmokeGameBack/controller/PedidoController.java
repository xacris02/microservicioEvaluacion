package com.example.SmokeGameBack.controller;

import com.example.SmokeGameBack.model.Pedido;
import com.example.SmokeGameBack.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@CrossOrigin(origins = "http://localhost:3000")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping("/crear")
    public Pedido crearPedido(@RequestBody Pedido pedido) {
        pedido.setEstado("COMPLETADO");
        return pedidoRepository.save(pedido);
    }

    @GetMapping("/usuario")
    public List<Pedido> obtenerPedidosUsuario(@RequestParam String email) {
        return pedidoRepository.findByUsuarioEmail(email);
    }

    @GetMapping
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    @PostMapping("/solicitar-reembolso/{id}")
    public ResponseEntity<?> solicitarReembolso(@PathVariable Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElse(null);
        if (pedido != null) {
            pedido.setEstado("SOLICITUD_REEMBOLSO");
            pedidoRepository.save(pedido);
            return ResponseEntity.ok("Solicitud enviada");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/aprobar-reembolso/{id}")
    public ResponseEntity<?> aprobarReembolso(@PathVariable Long id) {
        if (pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return ResponseEntity.ok("Reembolso aprobado y pedido eliminado");
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/rechazar-reembolso/{id}")
    public ResponseEntity<?> rechazarReembolso(@PathVariable Long id) {
        Pedido pedido = pedidoRepository.findById(id).orElse(null);
        if (pedido != null) {
            pedido.setEstado("COMPLETADO");
            pedidoRepository.save(pedido);
            return ResponseEntity.ok("Reembolso rechazado");
        }
        return ResponseEntity.notFound().build();
    }
}
