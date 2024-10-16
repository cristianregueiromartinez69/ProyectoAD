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

    public List<LibrosRegistroDTO>formatLibrosToXml(LibrosRegistroDTO librosRegistroDTO) {
        LibrosXMLSave librosXMLSave = new LibrosXMLSave();
        List<LibrosRegistroDTO> misLibrosRegistrosXml = new ArrayList<>();
        String fechaLectura = librosXMLSave.changeFormatDateToString(librosRegistroDTO.getFechaLectura());
        String fechaRegistro = librosXMLSave.changeFormatDateToString(librosRegistroDTO.getFechaRegistro());
        misLibrosRegistrosXml.add(new LibrosRegistroDTO(librosRegistroDTO.getIsbn(),librosRegistroDTO.getAutor(), librosRegistroDTO.getNombre(), librosXMLSave.changeStringToDate(fechaLectura),librosXMLSave.changeStringToDate(fechaRegistro)));

        return misLibrosRegistrosXml;
    }



}
