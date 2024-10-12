package com.cristian.bookmanage.registrousuarios.controlador;

import com.cristian.bookmanage.registrousuarios.dto.UsuarioRegistroDTO;
import com.cristian.bookmanage.registrousuarios.servicio.MongoConnectionService;
import com.cristian.bookmanage.registrousuarios.servicio.UsuarioServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registro")
public class UsuarioRegistroControlador {

    private final UsuarioServicio usuarioServicio;
    private final MongoConnectionService mongoConnectionService;

    public UsuarioRegistroControlador(UsuarioServicio usuarioServicio, MongoConnectionService mongoConnectionService) {
        this.usuarioServicio = usuarioServicio;
        this.mongoConnectionService = mongoConnectionService;
    }



    @PostMapping
    public ResponseEntity<String> registrarCuentaUsuario(@RequestBody UsuarioRegistroDTO registroDTO) {
        usuarioServicio.save(registroDTO);
        return new ResponseEntity<>("Usuario registrado exitosamente", HttpStatus.CREATED);
    }


    /**
    @PostMapping
    public ResponseEntity<String> registrarCuentaUsuarioMongoDb(@RequestBody UsuarioRegistroDTO registroDTO){

        try{
            mongoConnectionService.save(registroDTO);
            return new ResponseEntity<>("Usuario registrado correctamente", HttpStatus.CREATED);
        }catch(Exception e){

            System.out.println("Error al registrar usuario " + e.getMessage());
            return new ResponseEntity<>("Error al registrar usuario: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
**/


}
