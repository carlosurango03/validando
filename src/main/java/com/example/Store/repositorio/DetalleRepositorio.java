package com.example.Store.repositorio;

import com.example.Store.modelos.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DetalleRepositorio extends JpaRepository <Detalle,Integer>{
}