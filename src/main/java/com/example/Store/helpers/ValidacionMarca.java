package com.example.Store.helpers;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class ValidacionMarca {
    private EvaluarPatron evaluarPatron=new EvaluarPatron();

    public boolean validarNombreMarca(String nombreMarca)throws Exception{
        String regex = "^[a-zA-Z\\s]+$";
        if (!this.evaluarPatron.evaluarPatron(nombreMarca,regex)){
            throw new Exception("Reviza el nombre de la marca");
        }
        return true;
    }

    public boolean validarNit(String nit)throws Exception{
        String regex = "^[0-9]+$";
        if (!this.evaluarPatron.evaluarPatron(nit,regex)){
            throw new Exception("Reviza el nit");
        }
        return true;
    }

    public boolean validarAnoCreacion(String anoCreacion)throws Exception{
        String regex = "^\\d{2}/\\d{2}/\\d{4}$";

        if (!this.evaluarPatron.evaluarPatron(anoCreacion,regex)){
            throw new Exception("Reviza el año de creacion");
        }
        return true;
    }

}
