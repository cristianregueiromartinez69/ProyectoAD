package com.cristian.bookmanage.iniciosesionusuarios.servicio;

import com.cristian.bookmanage.iniciosesionusuarios.modelo.DatosLogin;
import com.cristian.bookmanage.registrousuarios.modelo.Usuarios;

/**
 * Interfaz que tiene el metodo de hacer autenticación de inicio de sesión
 * @author cristian
 * @version 1.0
 */
public interface InicioSesionServicio {

    //metodo que nos devuelve true o false y recibe un objeto de tipo datoslogin
    public Boolean checkUsuarios(DatosLogin datosLogin);
}
