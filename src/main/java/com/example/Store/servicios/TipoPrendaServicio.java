package com.example.Store.servicios;

import com.example.Store.helpers.ValidacionTipoPrenda;
import com.example.Store.modelos.TipoPrenda;
import com.example.Store.modelos.Usuario;
import com.example.Store.repositorio.TipoPrendaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TipoPrendaServicio {
    @Autowired
    ValidacionTipoPrenda validacionTipoPrenda;
    @Autowired
    TipoPrendaRepositorio tipoPrendaRepositorio;

    public TipoPrenda guardarTipoPrenda(TipoPrenda datosTipoPrenda) throws Exception{
        try {
            if (validacionTipoPrenda.validarNombre(datosTipoPrenda.getNombre()) == false) {
                throw new Exception("NOMBRE INVALIDO, REVISE PORFAVOR");
            }
            return tipoPrendaRepositorio.save(datosTipoPrenda);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }


    public  TipoPrenda buscarTipoPrendaPorId(Integer idUsuario)throws Exception{
        try{
            if (tipoPrendaRepositorio.findById(idUsuario).isPresent()){
                return tipoPrendaRepositorio.findById(idUsuario).get();
            } else {
                throw new Exception("Usuario no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<TipoPrenda> buscarTodosTipoPrenda()throws Exception{
        try {
            return tipoPrendaRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public TipoPrenda modificarTipoPrenda(){
        return null;
    }

    public boolean eliminarTipoPrenda(){
        return true;
    }


}
