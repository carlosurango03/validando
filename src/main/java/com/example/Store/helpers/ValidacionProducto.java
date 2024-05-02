package com.example.Store.helpers;

import org.springframework.stereotype.Component;

@Component
public class ValidacionProducto {
    private EvaluarPatron evaluarPatron=new EvaluarPatron();

    public boolean validarNombreProducto(String nombreProducto)throws Exception{
        String regex = "^[a-zA-Z\\s]{1,60}$";
        if (!this.evaluarPatron.evaluarPatron(nombreProducto,regex)){
            throw new Exception("Reviza el nombre del producto");
        }

        return true;
    }

    public boolean validarReferencia(String referencia)throws Exception{
        String regex = "^[a-zA-Z\\s]{1,14}$";
        if (!this.evaluarPatron.evaluarPatron(referencia,regex)){
            throw new Exception("Reviza la referencia");
        }
        if (referencia.length()>14){
            throw new Exception("cantidad maxima de caracteres son de 14");
        }
        return true;
    }

    public boolean validarTalla(String talla)throws Exception{
        String regex = "^[a-zA-Z\\s]{1,3}$";
        if (!this.evaluarPatron.evaluarPatron(talla,regex)){
            throw new Exception("Reviza la talla");
        }
        if (talla.length()>3){
            throw new Exception("la cantidad maxima de caracteres es de 3");
        }

        return true;
    }

    public boolean validarCantidadBodega(String cantidadBodega)throws Exception{
        String regex = "^[0-9]+$";
        if (!this.evaluarPatron.evaluarPatron(cantidadBodega,regex)){
            throw new Exception("Reviza la cantiada en bodega, solo se permiten numeros");
        }
        return true;
    }

    public boolean validarPrecioUnitario(String precioUnitario)throws Exception{
        String regex = "^[0-9]+(\\.[0-9]+)?$";
        if (!this.evaluarPatron.evaluarPatron(precioUnitario,regex)){
            throw new Exception("Reviza el costo");
        }
        return true;
    }

    public boolean validarDescripcion(String descripcion)throws Exception{
        String regex = "^[a-zA-Z\\s]{1,100}$";
        if (!this.evaluarPatron.evaluarPatron(descripcion,regex)){
            throw new Exception("Reviza la descripcion solo se perniten letrs y espacios");
        }
        if(descripcion.length()>100){
            throw new Exception("solo se perniten 100 caracteres");
        }

        return true;
    }

    public boolean validarFotografia(String fotografia)throws Exception{
        String regex = "^gs://[a-zA-Z0-9-._~/]+$";
        if (!this.evaluarPatron.evaluarPatron(fotografia,regex)){
            throw new Exception("Reviza la fotografia");
        }

        return true;
    }

}
