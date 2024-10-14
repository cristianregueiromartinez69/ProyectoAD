package com.cristian.bookmanage.registrousuarios.modelo;

import jakarta.persistence.*;

/**
 * Clase que implementa hibernate para transformarla en una tabla de la base de datos
 * @author cristian
 * @version 1.0
 */
@Entity //la clase es una entidad, es decir, una tabla
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "email"))//se llama usuarios y la columna email no se puede repetir
public class Usuarios {

    //la clave primaria y ponemos que se genere automaticamente +1, es decir, que se añada un +1 cada vez que se introduce un dato
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * los atributos con sus columnas y el nombre
     */
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    public Usuarios() {
    }

    /**
     * Constructor de la entidad usuarios
     * @param nombre columna que serán los nombres de los usuarios
     * @param email columna que serán los emails de los usuarios
     * @param password columna que serán las contraseñas de los usuarios
     */
    public Usuarios(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    /**
     * Constructor de la entidad usuarios
     * @param id columna que serán los ids de los usuarios
     * @param nombre columna que serán los nombres de los usuarios
     * @param email columna que serán los emails de los usuarios
     * @param password columna que serán las contraseñas de los usuarios
     */
    public Usuarios(Long id, String nombre, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    /**
     * Constructor de la entidad usuarios
     * @param email columna que serán los emails de los usuarios
     * @param password columna que serán las contraseñas de los usuarios
     */
    public Usuarios(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * getter y setter de la entidad
     * @return los atributos correspondientes
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
