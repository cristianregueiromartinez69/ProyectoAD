package com.cristian.bookmanage;

import com.cristian.bookmanage.registrolibros.servicio.LibroServicioImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestLibroServicioImpl {

    @Autowired
    private LibroServicioImpl libroServicio;

    @Test
    void checkIfAIsbnStartsWithCorrectPrefixesTrue(){
        boolean prefixe = libroServicio.checkStartIsbn("979-");
        Assertions.assertTrue(prefixe);
    }
    @Test
    void checkIfAIsbnStartsWithCorrectPrefixesFalse(){
        boolean prefixe = libroServicio.checkStartIsbn("971-");
        Assertions.assertFalse(prefixe);
    }
}
