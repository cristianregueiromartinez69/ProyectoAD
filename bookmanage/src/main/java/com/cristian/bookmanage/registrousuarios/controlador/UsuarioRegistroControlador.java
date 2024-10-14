package com.cristian.bookmanage.registrousuarios.controlador;

import com.cristian.bookmanage.registrousuarios.dto.UsuarioRegistroDTO;
import com.cristian.bookmanage.registrousuarios.servicio.MongoConnectionService;
import com.cristian.bookmanage.registrousuarios.servicio.UsuarioServicio;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Endpoint de swagger para comprobar los registros de usuario en la aplicacion
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/api/registro")
public class UsuarioRegistroControlador {

    //variables privadas finales con los servicios de postgres y mongodb
    private final UsuarioServicio usuarioServicio;
    private final MongoConnectionService mongoConnectionService;

    public UsuarioRegistroControlador(UsuarioServicio usuarioServicio, MongoConnectionService mongoConnectionService) {
        this.usuarioServicio = usuarioServicio;
        this.mongoConnectionService = mongoConnectionService;
    }


    /**
     * metodo post para enviar informacion al servidor y crear un usuario
     * @param registroDTO el objeto de registro con la información del usuario
     * @return el mensaje de exito o fracaso
     */
    @PostMapping
    public ResponseEntity<String> registrarCuentaUsuario(@RequestBody UsuarioRegistroDTO registroDTO) {
        //llamamos a los metodos de las interfaces para guardar la información
        usuarioServicio.save(registroDTO);
        mongoConnectionService.save(registroDTO);
        return new ResponseEntity<>("Usuario registrado exitosamente", HttpStatus.CREATED);
    }







}
