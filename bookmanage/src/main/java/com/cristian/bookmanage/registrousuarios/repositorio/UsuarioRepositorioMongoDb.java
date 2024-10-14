package com.cristian.bookmanage.registrousuarios.repositorio;

import com.cristian.bookmanage.registrousuarios.dto.UsuarioRegistroDTO;
import com.cristian.bookmanage.registrousuarios.modelo.Usuarios;
import com.cristian.bookmanage.registrousuarios.modelo.UsuariosMongoDb;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Clase repositorio que realiza las operaciones crud de manera rapida sin escribir consultas manualmente
 * @author cristian
 * @version 1.0
 */
@Repository
public interface UsuarioRepositorioMongoDb extends MongoRepository<UsuarioRegistroDTO, String> {

    Optional<UsuarioRegistroDTO> findByEmailAndPassword(String email, String password); //consulta opcional para encontrar el email del usuario al iniciar sesion
}
