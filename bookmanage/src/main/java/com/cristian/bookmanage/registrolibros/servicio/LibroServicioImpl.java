package com.cristian.bookmanage.registrolibros.servicio;

import com.cristian.bookmanage.registrolibros.dto.LibrosRegistroDTO;
import com.cristian.bookmanage.registrolibros.modelo.Libros;
import com.cristian.bookmanage.registrolibros.registroxml.LibrosXMLSave;
import com.cristian.bookmanage.registrolibros.repositorio.LibrosRepositorios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que funcionará como servicio de la aplicación. La lógica irá aquí y está será la capa intermedia entre el repositorio y el controlador
 *
 * @author cristian
 * @version 1.0
 */
@Service
public class LibroServicioImpl implements LibroServicio {

    //inyectamos las dependencias del repositorio de libros en la variables
    @Autowired
    private LibrosRepositorios librosRepositorios;


    /**
     * Sobreescribimos el metodo ya que implementamos la interfaz y guardamos los libros
     *
     * @param libroRegistroDTO los datos de los libros a través de la dto
     * @return el libro guardado a través del metodo del repositorio que guardará el libro en la base de datos
     */
    @Override
    public Libros saveBooks(LibrosRegistroDTO libroRegistroDTO) {
        Libros libro = new Libros(libroRegistroDTO.getIsbn(), libroRegistroDTO.getAutor(),
                libroRegistroDTO.getNombre(), libroRegistroDTO.getFechaLectura(), libroRegistroDTO.getFechaRegistro());

        return librosRepositorios.save(libro);
    }


    /**
     * Método para comprobar si el isbn empieza por los prefijos correctos
     *
     * @param isbn el isbn proporcionado
     * @return true o false dependiendo del isbn que introduzcas
     */
    public boolean checkStartIsbn(String isbn) {

        //array con los prefijos correctos del isbn
        String[] prefixes = {"978-", "979-"};

        //bucle para comprobar la coincidencia
        for (int i = 0; i < prefixes.length; i++) {
            if (isbn.startsWith(prefixes[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Método que comprueba si el isbn acaba en guion
     * @param isbn el isbn
     * @return true o false dependiendo de si acaba o no en guion
     */
    public boolean checkIsbnEndGuion(String isbn){
        return !isbn.endsWith("-");
    }

    /**
     * Metodo para comprobar si un isbn tiene 2 guiones juntos
     * @param isbn el isbn
     * @return true o false dependiendo del guion introducido
     */
    public boolean checkNoGuionesTogether(String isbn){

        //array con las letras del isbn
        char [] chars = isbn.toCharArray();
        //el guion a encontrar
        char guion = '-';
        //contador de guiones
        int contador = 0;

        /**
         * 1. recorremos el bucle
         * 2. si encuentra un guion, lo aumentamos a +1
         * 3. si el contador esta en 1 y la siguiente letra del isbn es un guion, devuelve false
         */
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == guion){
                contador++;
            }
            if(contador == 1 && chars[i + 1] == guion){
                return false;
            }
            contador = 0;
        }
        return true;
    }

    /**
     * Método para comprobar que el isbn tiene más de 1 guión
     * @param isbn el isbn proporcioando
     * @return true o false dependiendo del isbn que introdujeras
     */
    public boolean checkIsbnHasMoreThan2TimeGuion(String isbn) {

        //variable con el guion
        char guion = '-';
        //array con las letras del isbn
        char[] chars = isbn.toCharArray();

        //contador para las veces que se repite el guion
        int contador = 0;

        //bucle para recorrer el array, si encuentra el guion, se incrementa el contador
        for (char c : chars) {
            if (c == guion)
                contador++;
        }
        //si el contador es igual o mayor que 2, es válido
        if (contador >= 3) {
            return true;
        }
        return false;
    }

    /**
     * Método para comprobar que todos los caraceteres introducidos en el isbn son numeros o guiones
     * @param isbn el isbn proporcionado
     * @return true o false dependiendo del caracter a encontrar
     */
    public boolean checkIsbnHasOnlyNumbersAndGuion(String isbn){

        //creamos un array con las letras del isbn
        char[] chars = isbn.toCharArray();

        //recorremos el array
        for (char c : chars) {
            //si no es un numero y no es un guion, devuelve false
            if (!Character.isDigit(c) && c != '-') {
                return false;
            }
        }


        return true;

    }






}
