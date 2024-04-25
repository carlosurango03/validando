package com.example.Store.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto;
    @Column(name = "nombreProducto",nullable = false,length = 50)
    private String nombreProducto;//no vacio solo letras y espacios long-max 60
    @Column(name = "referencia",nullable = false,length = 25)
    private String referencia;//no vacio lon-max 14
    @Column(name = "talla",nullable = false,length = 10)
    private String talla;//long-max 3
    @Column(name = "fotografia",nullable = false,length = 255)
    private String fotografia;//no vacio long-max 255
    @Column(name = "cantidadBodega",nullable = false)
    private Integer cantidadBodega;//solo numeros pocitivos
    @Column(name = "precioUnitario",nullable = false)
    private Integer precioUnitario;//solo numeros pocitivos
    @Column(name = "descripcion",nullable = true,length = 100)
    private String descripcion;//lonmax-100

    @ManyToOne
    @JoinColumn(name = "id_detalle",referencedColumnName = "id_detalle")
    Detalle detalle;
    @ManyToOne
    @JoinColumn(name ="id_marca",referencedColumnName = "id_marca")
    Marca marca;
    @ManyToOne
    @JoinColumn(name = "id_tipoPrenda",referencedColumnName = "id_tipoPrenda")
    TipoPrenda tipoPrenda;


    public Producto() {
    }

    public Producto(Integer id, String nombreProducto, String referencia, String talla, Integer cantidadBodega, Integer precioUnitario, String descripcion, String fotografia) {
        this.id_producto = id;
        this.nombreProducto = nombreProducto;
        this.referencia = referencia;
        this.talla = talla;
        this.cantidadBodega = cantidadBodega;
        this.precioUnitario = precioUnitario;
        this.descripcion = descripcion;
        this.fotografia = fotografia;
    }

    public Integer getId() {
        return id_producto;
    }

    public void setId(Integer id) {
        this.id_producto = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public Integer getCantidadBodega() {
        return cantidadBodega;
    }

    public void setCantidadBodega(Integer cantidadBodega) {
        this.cantidadBodega = cantidadBodega;
    }

    public Integer getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Integer precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}