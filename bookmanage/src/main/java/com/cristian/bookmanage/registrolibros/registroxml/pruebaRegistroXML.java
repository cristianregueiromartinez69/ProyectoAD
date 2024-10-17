package com.cristian.bookmanage.registrolibros.registroxml;

import com.cristian.bookmanage.registrolibros.dto.LibrosRegistroDTO;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class pruebaRegistroXML {

    public static void saveBokkXML(){

        LibrosXMLSave librosXMLSave = new LibrosXMLSave();
        List<LibrosRegistroDTO> librosRegistroDTOS = new ArrayList<>();
        librosRegistroDTOS.add(new LibrosRegistroDTO("es2","cabiar", "tierras francesas de zorras", librosXMLSave.changeStringToDate("2020-12-02"),librosXMLSave.changeStringToDate("2019-02-18")));

        LibrosXMLSave librosXMLSave2 = new LibrosXMLSave("bookmanage/src/xmlfiles/libros.xml");
        librosXMLSave2.saveBooksInXML(librosRegistroDTOS);


    }
}
