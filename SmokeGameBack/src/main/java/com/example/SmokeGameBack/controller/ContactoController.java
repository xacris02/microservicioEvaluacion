package com.example.SmokeGameBack.controller;

import com.example.SmokeGameBack.model.Contacto;
import com.example.SmokeGameBack.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/contacto")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactoController {

    @Autowired
    private ContactoRepository contactoRepository;

    
    @PostMapping("/enviar")
    public ResponseEntity<?> enviarMensaje(@RequestBody Map<String, String> datos) {
        try {
            Contacto contacto = new Contacto();
            contacto.setNombre(datos.get("nombre"));
            contacto.setEmail(datos.get("email"));
            contacto.setAsunto(datos.get("asunto"));
            contacto.setMensaje(datos.get("mensaje"));
            
            contactoRepository.save(contacto);
            return ResponseEntity.ok("Mensaje recibido correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al guardar mensaje");
        }
    }

    
    @GetMapping
    public List<Contacto> listarMensajes() {
        return contactoRepository.findAll();
    }
}