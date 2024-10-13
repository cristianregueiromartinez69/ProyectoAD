package com.cristian.bookmanage.iniciosesionusuarios.servicio;

import com.cristian.bookmanage.iniciosesionusuarios.modelo.DatosLogin;
import com.cristian.bookmanage.registrousuarios.modelo.Usuarios;
import com.cristian.bookmanage.registrousuarios.repositorio.UsuarioRepositorio;
import com.cristian.bookmanage.registrousuarios.servicio.UsuarioServicio;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InicioSesionImpl implements InicioSesionServicio{

    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public Boolean checkUsuarios(DatosLogin datosLogin) {

        Optional<Usuarios> usuariosOPT = usuarioRepositorio.findByEmail(datosLogin.getEmail());

        if(usuariosOPT.isPresent()){
            Usuarios usuario = usuariosOPT.get();
            return usuario.getPassword().equals(datosLogin.getPassword());
        }
        else{
            return false;
        }

    }


}
