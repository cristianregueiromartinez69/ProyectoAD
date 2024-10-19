package com.cristian.bookmanage.registrolibros.dto;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

@JacksonXmlRootElement(localName = "Libros")
public class LibroRegistroDTOWrapper {

    private List<LibrosRegistroDTO> libro;

    public LibroRegistroDTOWrapper(List<LibrosRegistroDTO> libro) {
        this.libro = libro;
    }

    public LibroRegistroDTOWrapper() {
    }

    public List<LibrosRegistroDTO> getLibro() {
        return libro;
    }

    public void setLibro(List<LibrosRegistroDTO> libro) {
        this.libro = libro;
    }



}
