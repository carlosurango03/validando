package com.example.Store.servicios;

import com.example.Store.helpers.ValidacionMarca;
import com.example.Store.modelos.Marca;
import com.example.Store.modelos.Usuario;
import com.example.Store.repositorio.MarcaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MarcaServicio {

    @Autowired
    ValidacionMarca validacionMarca;
    @Autowired
    MarcaRepositorio marcaRepositorio;

    public Marca guardarMarca(Marca datosMarca) throws Exception{
        try{
            if(validacionMarca.validarNombreMarca(datosMarca.getNombreMarca())==false) {
                throw new Exception("NOMBRE INVALIDO, REVISE PORFAVOR");
            }
            if (validacionMarca.validarNit(datosMarca.getNit())==false) {
                throw new Exception("NIT INVALIDO, REVISE PORFAVOR");
            }
            if (validacionMarca.validarAnoCreacion(String.valueOf(datosMarca.getAnoCreacion()))==false){
                throw new Exception("AÑO CREACION INVALIDO, REVISE PORFAVOR");
            }
            return marcaRepositorio.save(datosMarca);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public  Marca buscarMarcaPorId(Integer idMarca)throws Exception{
        try{
            if (marcaRepositorio.findById(idMarca).isPresent()){
                return marcaRepositorio.findById(idMarca).get();
            } else {
                throw new Exception("Usuario no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Marca> buscarTodosMarca()throws Exception{
        try {
            return marcaRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Marca modificarMarca(){
        return null;
    }

    public boolean eliminarMarca(){
        return true;
    }

}
