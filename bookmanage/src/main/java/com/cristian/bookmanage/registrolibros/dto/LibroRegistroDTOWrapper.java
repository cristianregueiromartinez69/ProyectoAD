package com.cristian.bookmanage.registrolibros.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

/**
 * Clase que va a contener las listas de libros que se han de guardar en el xml
 * la anotacion indica que el root se va a llamar libros
 * @author cristian
 * @version 1.0
 */
@JacksonXmlRootElement(localName = "Libros")
public class LibroRegistroDTOWrapper {

    //creamos una lista privada de tipo libros registros
    private List<LibrosRegistroDTO> libro;

    /**
     * Contructor de la clase
     * @param libro el objeto de tipo libro
     */
    public LibroRegistroDTOWrapper(List<LibrosRegistroDTO> libro) {
        this.libro = libro;
    }

    public LibroRegistroDTOWrapper() {
    }

    //getters y setters de la clase
    public List<LibrosRegistroDTO> getLibro() {
        return libro;
    }

    public void setLibro(List<LibrosRegistroDTO> libro) {
        this.libro = libro;
    }



}
