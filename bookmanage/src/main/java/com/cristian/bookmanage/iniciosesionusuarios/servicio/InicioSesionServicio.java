package com.cristian.bookmanage.iniciosesionusuarios.servicio;

import com.cristian.bookmanage.iniciosesionusuarios.modelo.DatosLogin;
import com.cristian.bookmanage.registrousuarios.modelo.Usuarios;

public interface InicioSesionServicio {

    public Boolean checkUsuarios(DatosLogin datosLogin);
}
