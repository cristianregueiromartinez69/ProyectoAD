package com.cristian.bookmanage.registrolibros.servicio;

import com.cristian.bookmanage.registrolibros.dto.LibrosRegistroDTO;
import com.cristian.bookmanage.registrolibros.modelo.Libros;
import com.cristian.bookmanage.registrolibros.repositorio.LibrosRepositorios;
import org.springframework.beans.factory.annotation.Autowired;

public class LibroServicioImpl implements LibroServicio{

    @Autowired
    private LibrosRepositorios librosRepositorios;

    @Override
    public Libros saveBooks(LibrosRegistroDTO libroRegistroDTO) {
        Libros libro = new Libros(libroRegistroDTO.getIsbn(), libroRegistroDTO.getAutor(),
                libroRegistroDTO.getNombre(), libroRegistroDTO.getFechaLectura(), libroRegistroDTO.getFechaRegistro());

        return librosRepositorios.save(libro);
    }

}
