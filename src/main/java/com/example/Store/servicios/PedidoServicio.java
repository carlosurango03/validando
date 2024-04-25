package com.example.Store.servicios;

import com.example.Store.helpers.ValidacionPedido;
import com.example.Store.modelos.Pedido;
import com.example.Store.modelos.Usuario;
import com.example.Store.repositorio.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PedidoServicio {

    @Autowired
    ValidacionPedido validacionPedido;
    @Autowired
    PedidoRepositorio pedidoRepositorio;


    public Pedido guardarPedido(Pedido datosPedido) throws Exception{
        try{
            if(validacionPedido.validarFechaHora(datosPedido.getFechaYHora())==false) {
                throw new Exception("NOMBRE INVALIDO, REVISE PORFAVOR");
            }  return pedidoRepositorio.save(datosPedido);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }


    public  Pedido buscarPedidoPorId(Integer idPedido)throws Exception{
        try{
            if (pedidoRepositorio.findById(idPedido).isPresent()){
                return pedidoRepositorio.findById(idPedido).get();
            } else {
                throw new Exception("Usuario no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Pedido> buscarTodosPedidos()throws Exception{
        try {
            return pedidoRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Pedido modificarPedido(){
        return null;
    }

    public boolean eliminarPedido(){
        return true;
    }

}
