package com.cristian.bookmanage.iniciosesionusuarios.modelo;

/**
 * Clase con los datos de inicio de sesion
 * @author cristian
 * @version 1.0
 */
public class DatosLogin {

    //variables privadas que serán el correo y contraseña
    private String email;
    private String password;

    /**
     * Contructor de la clase
     * @param email el email
     * @param password la contraseña
     */
    public DatosLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public DatosLogin() {
    }

    /**
     * getters y setters de la clase
     * @return el atributo correspondiente
     */
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
