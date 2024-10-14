package com.cristian.bookmanage.registrousuarios.dto;

/**
 * Clase DTO que nos sirve de puente entre las entidades y el resto de la app
 * @author cristian
 * @version 1.0
 */
public class UsuarioRegistroDTO {


    /**
     * atributos privados de clase
     */
    private Long id;
    private String nombre;
    private String email;
    private String password;

    /**
     * Constructor de la clase
     * @param id el id del usuario
     * @param nombre el nombre del usuario
     * @param email el email del usuario
     * @param password la contraseña del usuario
     */
    public UsuarioRegistroDTO(Long id, String nombre, String email, String password) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
    }

    /**
     * Otro constructor de la clase usuario
     * @param nombre el nombre del usuario
     * @param email el email del usuario
     * @param password la contraseña del usuario
     */
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

    /**
     * getter y setter de la clase
     * @return los atributos corrrspondientes
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
