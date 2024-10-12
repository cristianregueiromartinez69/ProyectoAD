package com.cristian.bookmanage.registrousuarios.servicio;

import com.cristian.bookmanage.registrousuarios.dto.UsuarioRegistroDTO;
import com.cristian.bookmanage.registrousuarios.modelo.Usuarios;
import com.cristian.bookmanage.registrousuarios.repositorio.UsuarioRepositorio;
import com.cristian.bookmanage.registrousuarios.repositorio.UsuarioRepositorioMongoDb;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


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
