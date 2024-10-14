package com.cristian.bookmanage.registrousuarios.repositorio;

import com.cristian.bookmanage.registrousuarios.modelo.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Clase repositorio que realiza las operaciones crud de manera rapida sin escribir consultas manualmente
 * @author cristian
 * @version 1.0
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuarios, Long> {

    Optional<Usuarios> findByEmail(String email); //consulta opcional para encontrar el email del usuario al iniciar sesion

}
