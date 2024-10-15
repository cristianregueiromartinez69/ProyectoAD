package com.cristian.bookmanage.registrolibros.modelo;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "libros")
public class Libros {

    @Id
    @Column(unique = true, name = "isbn")
    private String isbn;

    @Column(name = "autor")
    private String autor;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha_lectura")
    private Date fechaLectura;

    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    public Libros(String isbn, String autor, String nombre, Date fechaLectura, Date fechaRegistro) {
        this.isbn = isbn;
        this.autor = autor;
        this.nombre = nombre;
        this.fechaLectura = fechaLectura;
        this.fechaRegistro = fechaRegistro;
    }

    public Libros(){

    }

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
