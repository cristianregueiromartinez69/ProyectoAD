package com.cristian.bookmanage;

import com.cristian.bookmanage.registrousuarios.servicio.UsuarioServicioImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestUsuariosServicioImpl {


    @Autowired
    private UsuarioServicioImpl usuarioServicio;

    @Test
    void chechLengthUserNameTrueComprobation() {

        boolean length = usuarioServicio.authenticationUserName("carlos");

        Assertions.assertTrue(length);

    }
    @Test
    void chechLengthUserNameFalseComprobation() {

        boolean length = usuarioServicio.authenticationUserName("a");

        Assertions.assertFalse(length);

    }


}
