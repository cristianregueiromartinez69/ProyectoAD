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
    void checkAllPosibilitysRegisterNameTrue(){
        boolean goodName = usuarioServicio.authenticationRegisterName("Javier garcía vázquez");
        Assertions.assertTrue(goodName);
    }
    @Test
    void checkAllPosibilitysRegisterNameFalse(){
        boolean badname = usuarioServicio.authenticationRegisterName("Pe1dro castaños ?de los puentes");
        Assertions.assertFalse(badname);
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

    @Test
    void checkIfAEmailHasAArobaAllSizeTrue(){
        boolean aroba = usuarioServicio.checkEmailHasAAroba("federico@hotmail.com");
        Assertions.assertTrue(aroba);
    }

    @Test
    void checkIfAEmailHasAArobaAllSizeFalse(){
        boolean aroba = usuarioServicio.checkEmailHasAAroba("federicogamil.com");
        Assertions.assertFalse(aroba);
    }

    @Test
    void checkIfAEmailHasAArobaAllSizeMoreThan1TimeTrue(){
        boolean aroba = usuarioServicio.checkEmailHasAArobaMoreThan1Time("carlos@hotmail.com");
        Assertions.assertTrue(aroba);
    }
    @Test
    void checkIfAEmailHasAArobaAllSizeMoreThan1TimeFalse(){
        boolean aroba = usuarioServicio.checkEmailHasAArobaMoreThan1Time("carlos@hotma@il.com");
        Assertions.assertFalse(aroba);
    }

    @Test
    void checkIfAEmailHasAPuntoFirstLetterTrue(){
        boolean punto = usuarioServicio.checkPuntoEmailFirstLetter("carlos@gmail.com");
        Assertions.assertTrue(punto);
    }

    @Test
    void checkIfAEmailHasAPuntoFirstLetterFalse(){
        boolean punto = usuarioServicio.checkPuntoEmailFirstLetter(".carlos@gmail.com");
        Assertions.assertFalse(punto);
    }

    @Test
    void checkIfAEmailHasAPuntoAllSizeTrue(){
        boolean punto = usuarioServicio.checkEmailHasAAPoint("carlos@gmail.com");
        Assertions.assertTrue(punto);
    }

    @Test
    void checkIfAEmailHasAPuntoAllSizeFalse(){
        boolean punto = usuarioServicio.checkEmailHasAAPoint("carlos@gmailcom");
        Assertions.assertFalse(punto);
    }

    @Test
    void checkIfAEmailHasAPuntoMoreThan1TimeTrue(){
        boolean punto = usuarioServicio.checkEmailHasAPointMoreThan1Time("carlos@gmail.com");
        Assertions.assertTrue(punto);
    }

    @Test
    void checkIfAEmailHasAPuntoMoreThan1TimeFalse(){
        boolean punto = usuarioServicio.checkEmailHasAPointMoreThan1Time("car.los@gmail.com");
        Assertions.assertFalse(punto);
    }

    @Test
    void chechIfAEmailHasAStrangeCaracteresTrue(){
        boolean strangeThigs = usuarioServicio.checkStrangeThingInEmail("carlos@gmail.com");
        Assertions.assertTrue(strangeThigs);
    }

    @Test
    void chechIfAEmailHasAStrangeCaracteresFalse(){
        boolean strangeThigs = usuarioServicio.checkStrangeThingInEmail("car[lo=s@gmail.com");
        Assertions.assertFalse(strangeThigs);
    }

    @Test
    void checkIfAEmailHasAValidateDomainTrue(){
        boolean domain = usuarioServicio.checkDomainEmail("carlos@gmail.com");
        Assertions.assertTrue(domain);
    }
    @Test
    void checkIfAEmailHasAValidateDomainFalse(){
        boolean domain = usuarioServicio.checkDomainEmail("carlos@gmail.coooom");
        Assertions.assertFalse(domain);
    }

    @Test
    void authenticationAllRegisterEmailTrue(){
        boolean email = usuarioServicio.authenticationRegisterEmail("mariavazquez@gmail.com");
        Assertions.assertTrue(email);
    }

    @Test
    void authenticationAllRegisterEmailFalse(){
        boolean email = usuarioServicio.authenticationRegisterEmail("mariavazque@gmail.cam");
        Assertions.assertFalse(email);
    }

    @Test
    void checkLengthRegisterPasswordTrue(){
        boolean password = usuarioServicio.checkLengthPassword("123456789lal");
        Assertions.assertTrue(password);
    }

    @Test
    void checkLengthRegisterPasswordFalse(){
        boolean password = usuarioServicio.checkLengthPassword("1234567");
        Assertions.assertFalse(password);
    }

}
