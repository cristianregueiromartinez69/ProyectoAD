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
@RequestMapping("api/libros")
public class LibroControlador {

    @Autowired
    private LibroServicio libroServicio;

    @Autowired
    private MongoConnectionService mongoConnectionService;

    @Autowired
    private LibrosXMLSave librosXMLSave;

    private List<LibrosRegistroDTO> misLibrosRegistrosXMl = new ArrayList<>();

    @PostMapping
    public ResponseEntity<String> registrarLibros(@RequestBody LibrosRegistroDTO librosRegistroDTO) {

        libroServicio.saveBooks(librosRegistroDTO);

        mongoConnectionService.saveBook(librosRegistroDTO);

        misLibrosRegistrosXMl.add(librosRegistroDTO);

        librosXMLSave.saveBooksInXML(misLibrosRegistrosXMl);

        return new ResponseEntity<>("Libro registrado exitosamente", HttpStatus.CREATED);
    }
}




