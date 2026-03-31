package com.example.SmokeGameBack.controller;

import com.example.SmokeGameBack.model.Usuario;
import com.example.SmokeGameBack.repository.UsuarioRepository;
import com.example.SmokeGameBack.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @PostMapping("/register")
    public ResponseEntity<?> registrar(@RequestBody Map<String, Object> datos) {
        try {
            Usuario usuario = new Usuario();
            
            usuario.setNombre((String) datos.get("fullname"));
            usuario.setEmail((String) datos.get("email"));
            usuario.setPassword((String) datos.get("password"));
            usuario.setRol((String) datos.get("role"));
            
            String fechaStr = (String) datos.get("dob"); 
            if (fechaStr != null && !fechaStr.isEmpty()) {
                usuario.setFechaNacimiento(LocalDate.parse(fechaStr)); 
            }

            String email = (String) datos.get("email");
            if (email != null && email.endsWith("@duocuc.cl")) {
                usuario.setDescuento(20);
            } else {
                usuario.setDescuento(0);
            }

            Usuario nuevoUsuario = usuarioService.registrar(usuario);
            return ResponseEntity.ok(nuevoUsuario);
            
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> datos) {
        String email = datos.get("email");
        String password = datos.get("password");

        Usuario usuario = usuarioService.login(email, password);

        if (usuario != null) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarUsuario(@PathVariable Long id, @RequestBody Map<String, Object> datos) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();

            if (datos.containsKey("fullname")) usuario.setNombre((String) datos.get("fullname"));
            if (datos.containsKey("email")) usuario.setEmail((String) datos.get("email"));
            if (datos.containsKey("role")) usuario.setRol((String) datos.get("role"));

            if (datos.containsKey("password")) {
                String nuevaPass = (String) datos.get("password");
                if (nuevaPass != null && !nuevaPass.trim().isEmpty()) {
                    usuario.setPassword(nuevaPass);
                }
            }

            if (datos.containsKey("dob")) {
                String fechaStr = (String) datos.get("dob");
                if (fechaStr != null && !fechaStr.isEmpty()) {
                    usuario.setFechaNacimiento(LocalDate.parse(fechaStr));
                }
            }

            usuarioRepository.save(usuario);
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.ok("Usuario eliminado correctamente");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
