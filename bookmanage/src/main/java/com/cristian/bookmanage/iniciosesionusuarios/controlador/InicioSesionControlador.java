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

@RestController
@RequestMapping("/api/login")
public class InicioSesionControlador {

    private InicioSesionServicio inicioSesionServicio;

    @Autowired
    private MongoConnectionService mongoConnectionService;

    @Autowired
    public  InicioSesionControlador(InicioSesionServicio inicioSesionServicio){
        this.inicioSesionServicio = inicioSesionServicio;
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody DatosLogin datosLogin){

        Boolean exitoLogin = inicioSesionServicio.checkUsuarios(datosLogin);
        Boolean exitoLoginMB = mongoConnectionService.checkUser(datosLogin.getEmail(), datosLogin.getPassword());

        if(exitoLogin && exitoLoginMB){
            return new ResponseEntity<>("Inicio de sesión exitoso", HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Email o contraseña erroneos, vuelve a intentarlo", HttpStatus.UNAUTHORIZED);
        }


    }

}
