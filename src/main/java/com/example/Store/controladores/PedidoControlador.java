package com.example.Store.controladores;

import com.example.Store.modelos.Pedido;
import com.example.Store.modelos.Usuario;
import com.example.Store.servicios.PedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("storeapi/v1/pedido")
public class PedidoControlador {
    @Autowired
    PedidoServicio pedidoServicio;

    @PostMapping
    public ResponseEntity<?> guardarPedido(@RequestBody Pedido datosPedido) {
        try {

            return  ResponseEntity
                    .status(HttpStatus.OK)
                    .body(pedidoServicio.guardarPedido(datosPedido));

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
                    .body(pedidoServicio.buscarTodosPedidos());

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
                    .body(pedidoServicio.buscarPedidoPorId(id));

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
