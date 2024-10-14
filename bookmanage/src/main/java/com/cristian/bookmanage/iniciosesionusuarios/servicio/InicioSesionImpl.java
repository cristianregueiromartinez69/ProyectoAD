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

/**
 * Esta clase va a funcionar como el servicio de la aplicacion
 * Manejaremos toda la lógica aquí que haya entre ek repositorio y el controlador
 * @author cristian
 * @version 1.0
 */
@Service
public class InicioSesionImpl implements InicioSesionServicio{

    //los autowired nos inyectan las dependecias automaticamente
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private MongoConnectionService mongoConnectionService;


    /**
     * Metodo para comprobar si existe o no el usuario registrado en la base de datos
     * @param datosLogin el objeto de tipo datoslogin
     * @return true o false dependiendo de si hubo o no exito en la conexion
     */
    @Override
    public Boolean checkUsuarios(DatosLogin datosLogin) {

        //creamos un usuario con los datos del login
        Usuarios usuarioComprobar = new Usuarios(datosLogin.getEmail(), datosLogin.getPassword());

        //usamos la clase opcional para acceder a la opcion del repositorio
        Optional<Usuarios> usuariosOPT = usuarioRepositorio.findByEmail(usuarioComprobar.getEmail());


        //si existe el usuario nos devuelve true si coincide la contraseña
        if(usuariosOPT.isPresent()){
            Usuarios usuario = usuariosOPT.get();
            return usuario.getPassword().equals(usuarioComprobar.getPassword());
        }
        else{
            return false;
        }

    }


}
