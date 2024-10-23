package com.cristian.bookmanage.registrousuarios.controlador;

import com.cristian.bookmanage.registrousuarios.dto.UsuarioRegistroDTO;
import com.cristian.bookmanage.registrousuarios.excepciones.EmailRegistroExcepcion;
import com.cristian.bookmanage.registrousuarios.excepciones.NombreRegistroExcepcion;
import com.cristian.bookmanage.registrousuarios.excepciones.PasswordRegistroExcepcion;
import com.cristian.bookmanage.registrousuarios.servicio.MongoConnectionService;
import com.cristian.bookmanage.registrousuarios.servicio.UsuarioServicio;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

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
        try{
            usuarioServicio.save(registroDTO);
            mongoConnectionService.save(registroDTO);
            return new ResponseEntity<>("Usuario registrado exitosamente", HttpStatus.CREATED);
        }catch(NombreRegistroExcepcion nombreException){
            return new ResponseEntity<>("formato de nombre incorrecto, vuelve a intentarlo", HttpStatus.BAD_REQUEST);
        }catch (EmailRegistroExcepcion emailException){
            return new ResponseEntity<>("Formato de email incorrecto, vuelve a intentarlo", HttpStatus.BAD_REQUEST);
        }catch(PasswordRegistroExcepcion passEx){
            return new ResponseEntity<>("Formato contraseña erroneo, debe ser de 12 o más carácteres, llevar mínimo 1 numero y 1 carácter especial, vuelve a intentarlo", HttpStatus.BAD_REQUEST);
        }catch(DataIntegrityViolationException dataEx){
            return new ResponseEntity<>("Ese email ya es de otro usuario, por favor, escribe uno nuevo", HttpStatus.BAD_REQUEST);
        }

    }







}
