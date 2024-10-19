package com.cristian.bookmanage.registrolibros.registroxml;

import com.cristian.bookmanage.registrolibros.dto.LibroRegistroDTOWrapper;
import com.cristian.bookmanage.registrolibros.dto.LibrosRegistroDTO;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * Clase para manejar la lógica de los elementos guardados en listas para escribir en xml
 * @author cristian
 * @version 1.0
 */
@Component
public class LibrosXMLSave {


    /**
     * Metodo para guardar datos en fichero xml
     * @param librosRegistroDTO el libro ha guardar
     * @param filePath la ruta donde estará el archivo
     * @throws IOException lanzamos una excepcion que será recogida en el controlador
     */
    public void guardarLibroEnXML(LibrosRegistroDTO librosRegistroDTO, String filePath) throws IOException {

        /**
         * Para guardar los datos, utilizaremos la biblioteca Jackson que se va a encargar de serializar objetos vaja en xml y viceversa
         * tenemos que importar las dependencias en nuestro pon.xml o en grandle si usamos gradle
         * Usad la version más reciente
         * Usamos la clase XmlMapper  e instanciamos una lista de libros
         */
        XmlMapper xmlMapper = new XmlMapper();
        List<LibrosRegistroDTO> librosList = new ArrayList<>();

        //guardamos el archivo y comprobamos si existe
        File file = new File(filePath);
        if (file.exists()) {
            try {
                /**
                 * Hacemos un objeto de la clase que usamos como contenedor. Esta clase es donde tenemos definido el root del archivo xml
                 * llamamos objeto que va a mapear los valores y leemos el archivo
                 * este metodo va a recibir 2 parametros:
                 * 1. el path del archivo
                 * 2. La clase donde está el root
                 */
                LibroRegistroDTOWrapper wrapper = xmlMapper.readValue(file, LibroRegistroDTOWrapper.class);

                //añadimos a la lista todos los elementos con el metodo definido en la clase del root que nos va a devolver la lista de los libros
                librosList.addAll(wrapper.getLibro());
            } catch (IOException e) {
                System.out.println("Error al leer el archivo existente: " + e.getMessage());
            }
        }
        /**
         * independientemente de si existe o no, se añade los datos a la lista
         * se crea el objeto de la clase con el root del xml
         * le damos un formato de fecha con el setDateFormat
         * le damos identacion con enable + el parametro SerializationFeature.INDENT_OUTPUT
         * Escribimos en el fichero con writeValue
         */
        librosList.add(librosRegistroDTO);

        LibroRegistroDTOWrapper wrapper = new LibroRegistroDTOWrapper(librosList);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        xmlMapper.setDateFormat(dateFormat);
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.writeValue(file, wrapper);

    }
}




