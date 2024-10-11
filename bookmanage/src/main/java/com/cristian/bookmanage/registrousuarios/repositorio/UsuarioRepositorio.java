package com.cristian.bookmanage.registrousuarios.repositorio;

import com.cristian.bookmanage.registrousuarios.modelo.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuarios, Long> {



}
