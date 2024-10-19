package com.cristian.bookmanage.registrolibros.registroxml;

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

@Component
public class LibrosXMLSave {


    public void guardarLibroEnXML(LibrosRegistroDTO librosRegistroDTO, String filePath) throws IOException {

        XmlMapper xmlMapper = new XmlMapper();
        List<LibrosRegistroDTO> librosList = new ArrayList<>();

        File file = new File(filePath);
        if (file.exists()) {
            try {
                LibrosRegistroDTO[] librosArray = xmlMapper.readValue(file, LibrosRegistroDTO[].class);
                for (LibrosRegistroDTO libro : librosArray) {
                    librosList.add(libro);
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo existente: " + e.getMessage());
            }
        }

        librosList.add(librosRegistroDTO);
           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
           xmlMapper.setDateFormat(dateFormat);
           xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.writeValue(file, librosList);


    }
}

/**
 *  XmlMapper xmlMapper = new XmlMapper();
 *         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
 *         xmlMapper.setDateFormat(dateFormat);
 *         xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
 *         xmlMapper.writeValue(new File(filePath), librosRegistroDTO);
 */


