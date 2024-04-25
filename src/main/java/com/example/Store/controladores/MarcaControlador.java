package com.example.Store.controladores;

import com.example.Store.modelos.Marca;
import com.example.Store.modelos.Usuario;
import com.example.Store.servicios.MarcaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("storeapi/v1/marca")
public class MarcaControlador {
    @Autowired
    MarcaServicio marcaServicio;

    @PostMapping
    public ResponseEntity<?> guardarMarca(@RequestBody Marca datosMarca) {
        try {

            return  ResponseEntity
                    .status(HttpStatus.OK)
                    .body(marcaServicio.guardarMarca(datosMarca));

        } catch (Exception error) {
            Map<String, Object> errores = new LinkedHashMap<>();
            errores.put("hora:", LocalDateTime.now());
            errores.put("mensaje", error.getMessage());
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errores);

        }
    }
    @GetMapping
    public ResponseEntity<?> consultarUsuarios() {
        try {

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(marcaServicio.buscarTodosMarca());

        } catch (Exception error) {

            Map<String, Object> errores = new LinkedHashMap<>();
            errores.put("hora:", LocalDateTime.now());
            errores.put("mensaje", error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errores);

        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> buscarUsuarioPorId(@PathVariable Integer id) {
        try {

            return ResponseEntity
                    .status(HttpStatus.FOUND)
                    .body(marcaServicio.buscarMarcaPorId(id));

        } catch (Exception error) {
            Map<String, Object> errores = new LinkedHashMap<>();
            errores.put("hora:", LocalDateTime.now());
            errores.put("mensaje", error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errores);
        }

    }

}

