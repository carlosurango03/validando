package com.example.Store.helpers;

import org.springframework.stereotype.Component;

@Component
public class ValidacionTipoPrenda {
    private EvaluarPatron evaluarPatron=new EvaluarPatron();

    public boolean validarNombre(String nombre)throws Exception{
        String regex = "^[a-zA-Z\\s]{1,80}$";
        if (!this.evaluarPatron.evaluarPatron(nombre,regex)){
            throw new Exception("Reviza el nombre");
        }
        return true;
    }
}
