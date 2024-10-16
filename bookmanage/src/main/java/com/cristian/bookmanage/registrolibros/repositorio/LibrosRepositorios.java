package com.cristian.bookmanage.registrolibros.repositorio;

import com.cristian.bookmanage.registrolibros.dto.LibrosRegistroDTO;
import com.cristian.bookmanage.registrolibros.modelo.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz repositorio donde hacemos los crud de los libros
 * @author cristian
 * @version 1.0
 */
@Repository
public interface LibrosRepositorios extends JpaRepository <Libros, String> {


}
