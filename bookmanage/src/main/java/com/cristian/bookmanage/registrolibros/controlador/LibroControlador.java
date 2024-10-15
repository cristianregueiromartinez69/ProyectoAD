package com.cristian.bookmanage.registrolibros.controlador;

import com.cristian.bookmanage.registrolibros.dto.LibrosRegistroDTO;
import com.cristian.bookmanage.registrolibros.servicio.LibroServicio;
import com.cristian.bookmanage.registrolibros.servicio.MongoConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registrolibro")
public class LibroControlador {

    @Autowired
    private LibroServicio libroServicio;

    @Autowired
    private MongoConnectionService mongoConnectionService;

    public ResponseEntity<String> registrarLibros(@RequestBody LibrosRegistroDTO librosRegistroDTO){


    }
}
