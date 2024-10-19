package com.cristian.bookmanage.registrolibros.dto;

import java.time.LocalDate;
import java.sql.Date;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * DT0 de la clase Libros que sirve de intermediaria entre la entidad y las demás capas de la aplicación
 * @author cristian
 * @version 1.0
 */
public class LibrosRegistroDTO {

    //atributos privados de la clase
    @JacksonXmlProperty(localName = "isbn")
    private String isbn;

    @JacksonXmlProperty(localName = "autor")
    private String autor;

    @JacksonXmlProperty(localName = "nombre")
    private String nombre;

    @JacksonXmlProperty(localName = "fechaLectura")
    private Date fechaLectura;

    @JacksonXmlProperty(localName = "fechaRegistro")
    private Date fechaRegistro;

    /**
     * Contructor de la clase
     * @param isbn el isbn del libro que será la clave primaria
     * @param autor el autor del libro
     * @param nombre el nombre del libro
     * @param fechaLectura la fecha de lectura del libro
     * @param fechaRegistro la fecha en que fue registrado el libro
     */
    public LibrosRegistroDTO(String isbn, String autor, String nombre, Date fechaLectura, Date fechaRegistro) {
        this.isbn = isbn;
        this.autor = autor;
        this.nombre = nombre;
        this.fechaLectura = fechaLectura;
        this.fechaRegistro = fechaRegistro;
    }

    public LibrosRegistroDTO() {

    }


    /**
     * getter y setter de la clase
     * @return los atributos correspondientes
     */
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaLectura() {
        return fechaLectura;
    }

    public void setFechaLectura(Date fechaLectura) {
        this.fechaLectura = fechaLectura;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}

