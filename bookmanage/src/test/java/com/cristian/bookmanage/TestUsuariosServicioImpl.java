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
    void checkLengthUserNameTrueComprobation() {

        boolean length = usuarioServicio.lengthUserName("carlos");

        Assertions.assertTrue(length);

    }
    @Test
    void checkLengthUserNameFalseComprobation() {

        boolean length = usuarioServicio.lengthUserName("a");

        Assertions.assertFalse(length);

    }

    @Test
    void CheckIfANameHasNumbersTrue(){
        boolean number = usuarioServicio.isDigitUserName("Javier mancillo rodriguez");
        Assertions.assertTrue(number);
    }

    @Test
    void CheckIfANameHasNumbersFalse(){
        boolean number = usuarioServicio.isDigitUserName("J123avier mancillo rodriguez");
        Assertions.assertFalse(number);
    }

    @Test
    void checkIfANameHasStrangerCharactersTrue(){
        boolean thing = usuarioServicio.strangeCharactersUsername("Camión");
        Assertions.assertTrue(thing);
    }
    @Test
    void checkIfANameHasStrangerCharactersFalse(){
        boolean thing = usuarioServicio.strangeCharactersUsername("Pepe de los monte´s");
        Assertions.assertFalse(thing);
    }

    @Test
    void checkIfAEmailHasAArobaFirstLetterTrue(){
        boolean aroba = usuarioServicio.checkArobaEmailFirstLetter("peregrino@gmail.com");
        Assertions.assertTrue(aroba);
    }
    @Test
    void checkIfAEmailHasAArobaFirstLetterFalse(){
        boolean aroba = usuarioServicio.checkArobaEmailFirstLetter("@peregrino.com");
        Assertions.assertFalse(aroba);
    }
}
