package com.example.Store.repositorio;

import com.example.Store.modelos.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ProductoRepositorio  extends JpaRepository<Producto,Integer>{
}
