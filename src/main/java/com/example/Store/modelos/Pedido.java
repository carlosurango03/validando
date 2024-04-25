package com.example.Store.modelos;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pedido;
    @Column(name ="fechaYHora",nullable = false )
    private String fechaYHora;//obligatorio y formato internacional

    public Pedido() {
    }

    public Pedido(Integer id, String fechaYHora) {
        this.id_pedido = id;
        this.fechaYHora = fechaYHora;
    }


    public Integer getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Integer id_pedido) {
        this.id_pedido = id_pedido;
    }

    public String getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(String fechaYHora) {
        this.fechaYHora = fechaYHora;
    }
}