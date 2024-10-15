package com.cristian.bookmanage.registrolibros.modelo;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;


@Entity
@Table(name = "libros", uniqueConstraints = @UniqueConstraint(columnNames = "isbn"))
public class Libros {

    @Id
    private String isbn;

    @Column(name = "autor")
    private String autor;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "fecha_lectura")
    private LocalDate fechaLectura;

    @Column(name = "fecha_registro")
    private LocalDate fechaRegistro;

    public Libros(String isbn, String autor, String nombre, LocalDate fechaLectura, LocalDate fechaRegistro) {
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

    public LocalDate getFechaLectura() {
        return fechaLectura;
    }

    public void setFechaLectura(LocalDate fechaLectura) {
        this.fechaLectura = fechaLectura;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
