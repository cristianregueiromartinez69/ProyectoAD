package com.cristian.bookmanage.registrousuarios.servicio;

import com.cristian.bookmanage.registrousuarios.dto.UsuarioRegistroDTO;
import com.cristian.bookmanage.registrousuarios.excepciones.EmailRegistroExcepcion;
import com.cristian.bookmanage.registrousuarios.excepciones.NombreRegistroExcepcion;
import com.cristian.bookmanage.registrousuarios.excepciones.PasswordRegistroExcepcion;
import com.cristian.bookmanage.registrousuarios.modelo.Usuarios;

/**
 * Interfaz con el metodo de guardar los usuarios registrados
 * @author cristian
 * @version 1.0
 */
public interface UsuarioServicio {

    //metodo que guarda usuarios con los datos del objeto usuarioRegistroDTO
    public Usuarios save(UsuarioRegistroDTO registroDTO) throws NombreRegistroExcepcion, EmailRegistroExcepcion, PasswordRegistroExcepcion;

}
