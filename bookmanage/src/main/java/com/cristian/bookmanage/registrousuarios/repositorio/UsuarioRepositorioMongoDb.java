package com.cristian.bookmanage.registrousuarios.repositorio;

import com.cristian.bookmanage.registrousuarios.dto.UsuarioRegistroDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorioMongoDb extends MongoRepository<UsuarioRegistroDTO, String> {


}
