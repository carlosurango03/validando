package com.example.Store.controladores;

import com.example.Store.modelos.Detalle;
import com.example.Store.servicios.DetalleServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("storeapi/v1/detalle")
public class DetalleControlador {

    @Autowired
    DetalleServicio detalleServicio;

    @PostMapping
    public ResponseEntity<?> guardarDetalle(@RequestBody Detalle datosDetalle) {
        try {

            return  ResponseEntity
                    .status(HttpStatus.OK)
                    .body(detalleServicio.guardarDetalle(datosDetalle));

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
                    .body(detalleServicio.buscarTodosDetalle());

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
                    .body(detalleServicio.buscarDetallePorId(id));

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


