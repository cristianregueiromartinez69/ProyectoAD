package com.cristian.bookmanage.registrolibros.controlador;

import com.cristian.bookmanage.registrolibros.dto.LibrosRegistroDTO;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Clase rest controller que es un end point de swagger
 * Comprobaremos si se realizan correctamente los registros de los libros
 * @author cristian
 * @version 1.0
 */
@RestController
@RequestMapping("/api/libro")
public class LibroControlador {


    //inyectamos las dependecias en la variable de tipo LibroServicio y en la conexion de mongo
    @Autowired
    private LibroServicio libroServicio;

    @Autowired
    private MongoConnectionService mongoConnectionService;

    LibrosXMLSave librosXMLSave = new LibrosXMLSave("bookmanage/src/xmlfiles/libros.xml");
    List <LibrosRegistroDTO> misLibrosRegistrosXMl = new ArrayList<>();



    /**
     * Metodo post mapping que va a enviar informacion al servidor para registrar un libro
     * @param librosRegistroDTO los datos de los libros
     * @return una respuesta dependiendo de si hubo o no exito a la hora de registrar el libro
     */
    @PostMapping
    public ResponseEntity<String> registrarLibros(@RequestBody LibrosRegistroDTO librosRegistroDTO){

        libroServicio.saveBooks(librosRegistroDTO);
        mongoConnectionService.saveBook(librosRegistroDTO);
        misLibrosRegistrosXMl.add(librosRegistroDTO);
        librosXMLSave.saveBooksInXML(libroServicio.saveBooks(misLibrosRegistrosXMl));
        return new ResponseEntity<>("Libro registrado exitosamente", HttpStatus.CREATED);
    }
}
