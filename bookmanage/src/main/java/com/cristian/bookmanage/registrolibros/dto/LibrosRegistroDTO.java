package com.cristian.bookmanage.registrolibros.dto;



import java.time.LocalDate;

public class LibrosRegistroDTO {

        private String isbn;

        private String autor;

        private String nombre;

        private LocalDate fechaLectura;

        private LocalDate fechaRegistro;

        public LibrosRegistroDTO(String isbn, String autor, String nombre, LocalDate fechaLectura, LocalDate fechaRegistro) {
            this.isbn = isbn;
            this.autor = autor;
            this.nombre = nombre;
            this.fechaLectura = fechaLectura;
            this.fechaRegistro = fechaRegistro;
        }

        public LibrosRegistroDTO(){

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

