package com.cristian.bookmanage.registrousuarios.servicio;

import com.cristian.bookmanage.registrousuarios.dto.UsuarioRegistroDTO;
import com.cristian.bookmanage.registrousuarios.modelo.Usuarios;

public interface UsuarioServicio {

    public Usuarios save(UsuarioRegistroDTO registroDTO);

    public Usuarios saveMongoDB(UsuarioRegistroDTO registroDTO);

}
