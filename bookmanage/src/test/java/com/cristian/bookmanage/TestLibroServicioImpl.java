package com.cristian.bookmanage;

import com.cristian.bookmanage.registrolibros.servicio.LibroServicioImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

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

    @Test
    void checkIfAIsbnHasMoreThan1TimeAGuionTrue(){
        boolean guion = libroServicio.checkIsbnHasMoreThan1TimeGuion("978-123-90");
        Assertions.assertTrue(guion);
    }
    @Test
    void checkIfAIsbnHasMoreThan1TimeAGuionFalse(){
        boolean guion = libroServicio.checkIsbnHasMoreThan1TimeGuion("978-12");
        Assertions.assertFalse(guion);
    }

    @Test
    void checkSplitIsbnTrue(){

        String isbn = "978-3-16-148410-0";

        String[] result = libroServicio.returnListDigitsIsbn(isbn);

        assertThat(result).containsExactly("978", "3", "16", "148410", "0");
    }

    @Test
    void checkAddAndConvertStringsInIntsIsbnTrue(){
        String[] isbnSeparado = {"978", "3", "16", "148410", "0"};

        int[] result = libroServicio.addDigitsIsbn(isbnSeparado);

        assertThat(result).containsExactly(978, 3, 16, 148410, 0);
    }
}
