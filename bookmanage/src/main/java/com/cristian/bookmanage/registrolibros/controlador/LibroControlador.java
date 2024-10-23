package com.cristian.bookmanage.registrolibros.controlador;

import com.cristian.bookmanage.registrolibros.dto.LibrosRegistroDTO;
import com.cristian.bookmanage.registrolibros.excepciones.AutorExcepcion;
import com.cristian.bookmanage.registrolibros.excepciones.IsbnExcepcion;
import com.cristian.bookmanage.registrolibros.excepciones.NombreLibroExcepcion;
import com.cristian.bookmanage.registrolibros.registroxml.LibrosXMLSave;
import com.cristian.bookmanage.registrolibros.servicio.LibroServicio;
import com.cristian.bookmanage.registrolibros.servicio.LibroServicioImpl;
import com.cristian.bookmanage.registrousuarios.servicio.MongoConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase rest controller que es un end point de swagger
 * Comprobaremos si se realizan correctamente los registros de los libros
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("api/libros")
public class LibroControlador {

    //inyeccion de dependencias en las variables automaticamente
    @Autowired
    private LibroServicio libroServicio;

    @Autowired
    private MongoConnectionService mongoConnectionService;

    @Autowired
    private LibrosXMLSave librosXMLSave;

    @PostMapping
    public ResponseEntity<String> registrarLibros(@RequestBody LibrosRegistroDTO librosRegistroDTO) {

        //guardamos los libros en las bass de datos
        try{
            libroServicio.saveBooks(librosRegistroDTO);

            mongoConnectionService.saveBook(librosRegistroDTO);
        }catch(IsbnExcepcion isEx){
            return new ResponseEntity<>("Formato isbn incorrecto, debe de tener entre 3 o 4 guiones, no ir juntos los guiones, empezar por 978 o 979, no acabar en guion el isbn, llevar solo numeros o guiones", HttpStatus.BAD_REQUEST);
        }catch(AutorExcepcion auEx){
            return new ResponseEntity<>("Nombre incorrecto, nada de numeros, caracteres raros o escribir una sola letra de nombre", HttpStatus.BAD_REQUEST);
        }catch(NombreLibroExcepcion noEx){
            return new ResponseEntity<>("Formato de nombre d elibro erróneo, nada de numeros, carácteres especiales y longitud mayor a 1 letra", HttpStatus.BAD_REQUEST);
        }


        /**
         * Intentamos guardar el xml, si no sale bien, salta un mensaje de error
         */
        try{
            librosXMLSave.guardarLibroEnXML(librosRegistroDTO, "C:/Users/crm23/OneDrive/Escritorio/dam2Clase/Acceso a Datos/Proyecto/bookmanage/src/xmlfiles/libros.xml");
        }catch(IOException e){
            return new ResponseEntity<>("Ups, no se pudo registrar el libro en xml", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("Libro registrado exitosamente", HttpStatus.CREATED);
    }
}




