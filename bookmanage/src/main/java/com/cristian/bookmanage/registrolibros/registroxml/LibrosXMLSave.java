package com.cristian.bookmanage.registrolibros.registroxml;

import com.cristian.bookmanage.registrolibros.dto.LibrosRegistroDTO;
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
import java.util.List;

public class LibrosXMLSave {

    private String filePath;

    public LibrosXMLSave(String filePath) {
        this.filePath = filePath;
    }

    public void saveBooksInXML(List<LibrosRegistroDTO>libroRegistroDTO){

        try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();

            Element root = document.createElement("Libros");
            document.appendChild(root);

            for (LibrosRegistroDTO libro : libroRegistroDTO) {
                Element libroElement = document.createElement("Libro");

                Element isbnElement = document.createElement("ISBN");
                isbnElement.appendChild(document.createTextNode(libro.getIsbn()));
                libroElement.appendChild(isbnElement);

                Element autorElement = document.createElement("Autor");
                autorElement.appendChild(document.createTextNode(libro.getAutor()));
                libroElement.appendChild(autorElement);

                Element nombreElement = document.createElement("Nombre");
                nombreElement.appendChild(document.createTextNode(libro.getNombre()));
                libroElement.appendChild(nombreElement);

                Element fechaLecturaElement = document.createElement("FechaLectura");
                fechaLecturaElement.appendChild(document.createTextNode(changeFormatDateToString(libro.getFechaLectura())));
                libroElement.appendChild(fechaLecturaElement);

                Element fechaRegistroElement = document.createElement("FechaRegistro");
                fechaRegistroElement.appendChild(document.createTextNode(changeFormatDateToString(libro.getFechaRegistro())));
                libroElement.appendChild(fechaRegistroElement);

                root.appendChild(libroElement);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(createOrcheckFile(filePath));

            transformer.transform(domSource, streamResult);

            System.out.println("Libros guardados en XML: " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String changeFormatDateToString(Date date){


        return date.toString();
    }

    private File createOrcheckFile(String path){

        File file = new File(path);
        if(file.exists() && file.isFile()){

            return file;
        }
        else{
            try{
                if(file.createNewFile()){
                    return file;
                }
            }catch(IOException e){
                System.out.println("No se pudo crear el archivo");
            }

        }
       return null;
    }

}
