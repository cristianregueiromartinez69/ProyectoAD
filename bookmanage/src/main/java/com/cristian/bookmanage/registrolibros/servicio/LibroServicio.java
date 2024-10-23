package com.cristian.bookmanage.registrolibros.servicio;

import com.cristian.bookmanage.registrolibros.dto.LibrosRegistroDTO;
import com.cristian.bookmanage.registrolibros.excepciones.AutorExcepcion;
import com.cristian.bookmanage.registrolibros.excepciones.IsbnExcepcion;
import com.cristian.bookmanage.registrolibros.excepciones.NombreLibroExcepcion;
import com.cristian.bookmanage.registrolibros.modelo.Libros;

/**
 * Interfaz servicio de libros donde llamamos a los metodos correspondientes que gestionan las acciones sobre los libros
 * @author cristian
 * @version 1.0
 */
public interface LibroServicio {

    /**
     * Metodo que guardará los datos de los libros
     * @param libroRegistroDTO los datos de los libros a través de la dto
     * @return el objeto libros
     */
    public Libros saveBooks(LibrosRegistroDTO libroRegistroDTO) throws IsbnExcepcion, AutorExcepcion, NombreLibroExcepcion;
}
