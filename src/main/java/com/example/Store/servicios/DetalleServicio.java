package com.example.Store.servicios;

import com.example.Store.helpers.ValidacionDetalle;
import com.example.Store.modelos.Detalle;
import com.example.Store.modelos.Usuario;
import com.example.Store.repositorio.DetalleRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetalleServicio {

    @Autowired
    ValidacionDetalle validacionDetalle;
    @Autowired
    DetalleRepositorio detalleRepositorio;

    public Detalle guardarDetalle(Detalle datosDetalle) throws Exception{
        try{
            if(validacionDetalle.validarCantidadProductos(String.valueOf(datosDetalle.getCantidadProductos()))==false) {
                throw new Exception("CANTIDAD DE PRODUCTOS INVALIDO, REVISE PORFAVOR");
            }
            if (validacionDetalle.validarCostoTotal(String.valueOf(datosDetalle.getCostoTotal()))==false)
                throw new Exception("COSTO TOTAL INVALIDO, REVISE PORFAVOR");
            return detalleRepositorio.save(datosDetalle);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public  Detalle buscarDetallePorId(Integer idDetalle)throws Exception{
        try{
            if (detalleRepositorio.findById(idDetalle).isPresent()){
                return detalleRepositorio.findById(idDetalle).get();
            } else {
                throw new Exception("Usuario no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Detalle> buscarTodosDetalle()throws Exception{
        try {
            return detalleRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Detalle modificarDetalle(){
        return null;
    }

    public boolean eliminarDetalle(){
        return true;
    }

}
