package com.cristian.bookmanage.iniciosesionusuarios.servicio;

import com.cristian.bookmanage.iniciosesionusuarios.modelo.DatosLogin;
import com.cristian.bookmanage.registrousuarios.modelo.Usuarios;
import com.cristian.bookmanage.registrousuarios.modelo.UsuariosMongoDb;
import com.cristian.bookmanage.registrousuarios.repositorio.UsuarioRepositorio;
import com.cristian.bookmanage.registrousuarios.repositorio.UsuarioRepositorioMongoDb;
import com.cristian.bookmanage.registrousuarios.servicio.MongoConnectionService;
import com.cristian.bookmanage.registrousuarios.servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InicioSesionImpl implements InicioSesionServicio{

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private MongoConnectionService mongoConnectionService;



    @Override
    public Boolean checkUsuarios(DatosLogin datosLogin) {

        Usuarios usuarioComprobar = new Usuarios(datosLogin.getEmail(), datosLogin.getPassword());

        Optional<Usuarios> usuariosOPT = usuarioRepositorio.findByEmail(usuarioComprobar.getEmail());


        if(usuariosOPT.isPresent()){
            Usuarios usuario = usuariosOPT.get();
            return usuario.getPassword().equals(usuarioComprobar.getPassword());
        }
        else{
            return false;
        }

    }


}
