package com.cristian.bookmanage.registrousuarios.repositorio;

import com.cristian.bookmanage.registrousuarios.dto.UsuarioRegistroDTO;
import com.cristian.bookmanage.registrousuarios.modelo.Usuarios;
import com.cristian.bookmanage.registrousuarios.modelo.UsuariosMongoDb;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepositorioMongoDb extends MongoRepository<UsuarioRegistroDTO, String> {

    Optional<UsuarioRegistroDTO> findByEmailAndPassword(String email, String password);
}
