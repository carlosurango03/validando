package com.example.Store.servicios;

import com.example.Store.helpers.ValidacionUsuario;
import com.example.Store.modelos.Usuario;
import com.example.Store.repositorio.UsuarioRepositirio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio {

    //en los servicios dobo inyectar las depedencias de las validaciones y las consultas o repositorios
    @Autowired
    ValidacionUsuario validacionUsuario;
    @Autowired
    UsuarioRepositirio usuarioRepositirio;

    // en el servicio se crea un metodo para cada una de las consultas en BD

    public  Usuario guardarUsuario(Usuario datosUsuario) throws  Exception{
        try{
            if(validacionUsuario.validarNombres(datosUsuario.getNombres())==false) {
                throw new Exception("NOMBRE INVALIDO, REVISE PORFAVOR");
            }
            if(validacionUsuario.validarCorreo(datosUsuario.getCorreo())==false) {
                throw new Exception("CORREO INVALIDO, REVISE PORFAVOR");
            }
            if(validacionUsuario.validarSexo(datosUsuario.getSexo())==false) {
                throw new Exception("SEXO INVALIDO, REVISE PORFAVOR");
            }
            if(validacionUsuario.validarCodigoPostal(datosUsuario.getCodigoPostal())==false) {
                throw new Exception("CODIGO POSTAL INVALIDO, REVISE PORFAVOR");
            }
            if(validacionUsuario.validarCorreo(datosUsuario.getCorreo())==false) {
                throw new Exception("CORREO INVALIDO, REVISE PORFAVOR");
            }
            return usuarioRepositirio.save(datosUsuario);
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public  Usuario buscarUsuarioPorId(Integer idUsuario)throws Exception{
        try{
            if (usuarioRepositirio.findById(idUsuario).isPresent()){
                return usuarioRepositirio.findById(idUsuario).get();
            } else {
                throw new Exception("Usuario no encontrado");
            }
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Usuario>buscarTodosUsuarios()throws Exception{
        try {
            return usuarioRepositirio.findAll();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Usuario modificarUsuario(){
        return null;
    }

    public boolean eliminarUsuario(){
        return true;
    }




}
