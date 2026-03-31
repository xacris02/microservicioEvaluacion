package com.example.SmokeGameBack.config;

import com.example.SmokeGameBack.model.Producto;
import com.example.SmokeGameBack.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(ProductoRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                System.out.println("Cargando productos iniciales...");

                List<Producto> productos = Arrays.asList(
                    crearProducto("Elden Ring (PS5,Pc,XboXseriesX)", 59990.0, "Videojuegos", "RPG de acción en mundo abierto...", "/img/elden.jpg", false, 10),
                    crearProducto("The Legend of Zelda: Tears of the Kingdom", 64990.0, "Videojuegos", "La secuela de Breath of the Wild...", "/img/TOKT.jpg", false, 15),
                    crearProducto("God of War (2018)", 39990.0, "Videojuegos", "Acompaña a Kratos y Atreus...", "/img/portadagow.jpg.jpeg", false, 20),
                    crearProducto("Catan", 29990.0, "Juegos de Mesa", "Juego de estrategia...", "/img/catan.jpg", false, 5),
                    crearProducto("Carcassonne", 24990.0, "Juegos de Mesa", "Juego de colocación de fichas...", "/img/carcass.jpg", false, 8),
                    crearProducto("Controlador Inalámbrico Xbox", 59990.0, "Accesorios", "Experiencia de juego cómoda...", "/img/controlx.jpg", false, 12),
                    crearProducto("Auriculares Gamer HyperX Cloud II", 79990.0, "Accesorios", "Sonido envolvente...", "/img/hypercloud.jpg", false, 0),
                    crearProducto("PlayStation 5", 549990.0, "Consolas", "Consola de última generación...", "/img/play5.jpg", false, 3),
                    crearProducto("PC Gamer ASUS ROG Strix", 1299990.0, "Computadores Gamer", "Equipo potente...", "/img/asus.jpg", false, 2),
                    crearProducto("Silla Gamer Secretlab Titan", 349990.0, "Sillas Gamer", "Diseñada para máximo confort...", "/img/SLtitan.jpg", false, 4),
                    crearProducto("Mouse Gamer Logitech G502 HERO", 49990.0, "Mouse", "Sensor de alta precisión...", "/img/logite.jpg", false, 20),
                    crearProducto("Mousepad Razer Goliathus", 29990.0, "Mousepad", "Superficie amplia con iluminación...", "/img/razer.jpg", false, 15),
                    crearProducto("Polera Gamer 'Level-Up'", 14990.0, "Poleras", "Camiseta cómoda y estilizada...", "/img/polera.jpg", false, 50),
                    crearProducto("Polerón Gamer Personalizado", 29990.0, "Polerones", "Polerón gamer cómodo...", "/img/poleron.jpg", false, 30),
                    crearProducto("Reparación de Consolas", 19990.0, "Servicio Técnico", "Diagnóstico y reparación...", "/img/reparacion.png", true, 999),
                    crearProducto("Mantención de PC Gamer", 29990.0, "Servicio Técnico", "Limpieza, cambio de pasta térmica...", "/img/reparacion.png", true, 999)
                );

                repository.saveAll(productos);
                System.out.println("¡Productos cargados exitosamente en la Base de Datos!");
            }
        };
    }

    private Producto crearProducto(String nombre, Double precio, String categoria, String descripcion, String imagenUrl, Boolean esServicio, Integer stock) {
        Producto p = new Producto();
        p.setNombre(nombre);
        p.setPrecio(precio);
        p.setCategoria(categoria);
        p.setDescripcion(descripcion);
        p.setImagenUrl(imagenUrl);
        p.setEsServicio(esServicio);
        p.setStock(stock);
        return p;
    }
}