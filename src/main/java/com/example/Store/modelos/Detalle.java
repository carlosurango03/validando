package com.example.Store.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle")
public class Detalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_detalle;
    @Column(name = "",nullable = false)
    private Integer costoTotal;//obligatorio solo numeros pocitivos
    @Column(name = "",nullable = false)
    private Integer cantidadProductos;//obligatorio solo numeros pocitivos

    public Detalle() {
    }

    public Detalle(Integer id, Integer costoTotal, Integer cantidadProductos) {
        this.id_detalle = id;
        this.costoTotal = costoTotal;
        this.cantidadProductos = cantidadProductos;
    }

    public Integer getId() {
        return id_detalle;
    }

    public void setId(Integer id) {
        this.id_detalle = id;
    }

    public Integer getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Integer costoTotal) {
        this.costoTotal = costoTotal;
    }

    public Integer getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(Integer cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }
}