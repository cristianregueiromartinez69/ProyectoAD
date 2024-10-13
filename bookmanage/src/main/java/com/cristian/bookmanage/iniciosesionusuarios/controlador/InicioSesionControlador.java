package com.cristian.bookmanage.iniciosesionusuarios.controlador;

import com.cristian.bookmanage.iniciosesionusuarios.modelo.DatosLogin;
import com.cristian.bookmanage.iniciosesionusuarios.servicio.InicioSesionImpl;
import com.cristian.bookmanage.iniciosesionusuarios.servicio.InicioSesionServicio;
import com.cristian.bookmanage.registrousuarios.servicio.MongoConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Esta clase funciona como una api rest, enviamos la informacion en formato json que será almacenada en 2 bases de datos
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/api/login")
public class InicioSesionControlador {

    //declaramos variables de las clases de servicio y conexion con mongoDb
    private InicioSesionServicio inicioSesionServicio;

    //inyectamos las dependencias automaticamente
    @Autowired
    private MongoConnectionService mongoConnectionService;

    @Autowired
    public  InicioSesionControlador(InicioSesionServicio inicioSesionServicio){
        this.inicioSesionServicio = inicioSesionServicio;
    }

    /**
     * Metodo post que envia informacion al servidor y para verificar un recurso
     * @param datosLogin el objeto de tipo datosLogin
     * @return si inicia o no inicia sesion
     */
    @PostMapping
    public ResponseEntity<String> login(@RequestBody DatosLogin datosLogin){

        //variables booleanas para verificar el inicio de sesion
        Boolean exitoLogin = inicioSesionServicio.checkUsuarios(datosLogin);
        Boolean exitoLoginMB = mongoConnectionService.checkUser(datosLogin.getEmail(), datosLogin.getPassword());

        /**
         * Si has introducido los campos correctamente, se inicia sesion y entras a la aplicacion
         * Si no, no entras
         */
        if(exitoLogin && exitoLoginMB){
            return new ResponseEntity<>("Inicio de sesión exitoso", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Email o contraseña erroneos, vuelve a intentarlo", HttpStatus.UNAUTHORIZED);
        }


    }

}
