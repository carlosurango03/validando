package com.example.Store.servicios;

import com.example.Store.helpers.ValidacionProducto;
import com.example.Store.modelos.Producto;
import com.example.Store.modelos.Usuario;
import com.example.Store.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoServicio {

    @Autowired
    ValidacionProducto validacionProducto;
    @Autowired
    ProductoRepositorio productoRepositorio;

    public Producto guardarProducto(Producto datosProducto) throws Exception{
        try{
            if(validacionProducto.validarNombreProducto(datosProducto.getNombreProducto())==false) {
                throw new Exception("NOMBRE INVALIDO, REVISE PORFAVOR");
            }
            if(validacionProducto.validarCantidadBodega(String.valueOf(datosProducto.getCantidadBodega()))==false) {
                throw new Exception("CANTIDAD INVALIDA, REVISE PORFAVOR");
            }
            if(validacionProducto.validarDescripcion(datosProducto.getDescripcion())==false) {
                throw new Exception("DESCRIPCION INVALIDA, REVISE PORFAVOR");
            }
            if(validacionProducto.validarFotografia(datosProducto.getFotografia())==false) {
                throw new Exception("FOTOGRAFIA INVALIDA, REVISE PORFAVOR");
            }
            if(validacionProducto.validarPrecioUnitario(String.valueOf(datosProducto.getPrecioUnitario()))==false) {
                throw new Exception("PRECIO UNITARIO INVALIDO, REVISE PORFAVOR");
            }
            if (validacionProducto.validarReferencia(datosProducto.getReferencia())==false){
                throw new Exception("REFERENCIA  INVALIDA, REVISE PORFAVOR");
            }
            if (validacionProducto.validarTalla(datosProducto.getTalla())==false){
                throw new Exception("TALLA INVALIDOA, REVISE PORFAVOR");}
            return productoRepositorio.save(datosProducto);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public  Producto buscarProductoPorId(Integer idProduto)throws Exception{
        try{
            if (productoRepositorio.findById(idProduto).isPresent()){
                return productoRepositorio.findById(idProduto).get();
            } else {
                throw new Exception("Usuario no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Producto> buscarTodosProductos()throws Exception{
        try {
            return productoRepositorio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Producto modificarProducto(){
        return null;
    }

    public boolean eliminarProducto(){
        return true;
    }

}
