package com.cristian.bookmanage.registrousuarios.dto;

/**
 * Clase DTO que nos sirve de puente entre las entidades y el resto de la app
 * @author cristian
 * @version 1.0
 */
public class UsuarioRegistroDTO {


    private Long id;
    private String nombre;
    private String email;
    private String password;

    public UsuarioRegistroDTO(Long id, String nombre, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    public UsuarioRegistroDTO(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    public UsuarioRegistroDTO(String email) {
        this.email = email;
    }

    public UsuarioRegistroDTO() {
    }

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
