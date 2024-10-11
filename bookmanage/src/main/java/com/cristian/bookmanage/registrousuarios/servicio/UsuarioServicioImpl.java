package com.cristian.bookmanage.registrousuarios.servicio;

import com.cristian.bookmanage.registrousuarios.dto.UsuarioRegistroDTO;
import com.cristian.bookmanage.registrousuarios.modelo.Usuarios;
import com.cristian.bookmanage.registrousuarios.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{

    private UsuarioRepositorio usuarioRepositorio;

    public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public Usuarios save(UsuarioRegistroDTO registroDTO) {
        Usuarios usuario = new Usuarios(registroDTO.getId(),
                registroDTO.getNombre(), registroDTO.getEmail(),
                registroDTO.getPassword());

        return usuarioRepositorio.save(usuario);
    }


}
