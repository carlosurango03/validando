package com.example.Store.helpers;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ValidacionPedido {
    private EvaluarPatron evaluarPatron=new EvaluarPatron();

    public boolean validarFechaHora(String fechaHora)throws Exception{
        System.out.println(fechaHora);
        String regex = "^\\d{2}/\\d{2}/\\d{4}$";

        if (!this.evaluarPatron.evaluarPatron(fechaHora,regex)){
            throw new Exception("Reviza la fecha y hora");
        }

        return true;
    }

}
