package com.cristian.bookmanage.registrousuarios.servicio;

import com.cristian.bookmanage.registrousuarios.dto.UsuarioRegistroDTO;
import com.cristian.bookmanage.registrousuarios.modelo.Usuarios;
import com.cristian.bookmanage.registrousuarios.repositorio.UsuarioRepositorio;
import com.cristian.bookmanage.registrousuarios.repositorio.UsuarioRepositorioMongoDb;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Clase que funciona como servicio para implementar la logica y separar el repositorio del controlador
 *
 * @author cristian
 * @version 1.0
 */
@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    //variable del repositorio
    private UsuarioRepositorio usuarioRepositorio;

    public UsuarioServicioImpl(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }


    /**
     * metodo a implementar ya que estamos implementando la interfaz Usuario servicios
     *
     * @param registroDTO el objeto de registro de los usuarios
     * @return el usuario registrado
     */
    @Override
    public Usuarios save(UsuarioRegistroDTO registroDTO) {
        //creamos un usuario nuevo con los datos del registro
        Usuarios usuario = new Usuarios(registroDTO.getId(),
                registroDTO.getNombre(), registroDTO.getEmail(),
                registroDTO.getPassword());

        //llamamos al metodo del repositorio que guarda los usuarios en la base de datos
        return usuarioRepositorio.save(usuario);
    }

    /**
     * Metodo para comprobar si un nombre tiene 2 o más letras (existen nombres con 2 letras, por ejemplo, Ed)
     *
     * @param name el nombre que le vamos a pasar
     * @return True o False en caso de tener menos o mas letras
     */
    public boolean lengthUserName(String name) {

        return name.length() >= 2;
    }

    public boolean isDigitUserName(String name) {

        char[] numeros = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] chars = name.toCharArray();
        for (char letra : chars) {

            for(char numero:numeros){
                if (letra == numero){
                    return false;
                }
            }

        }
        return true;

    }

    public boolean strangeCharactersUsername(String name){
        char[] caracteres = {'!', '|', '@', '"', '#', '·', '~', '$', '%', '€','¬','&','/','(',')','=','?','¿'
        ,'¡','º','ª','<','>','+','-','*','^','[',']','¨','{','}',',',';',':','_'};
        char[] chars = name.toCharArray();
        for (char letra : chars) {

            for(char numero:caracteres){
                if (letra == numero){
                    return false;
                }
            }

        }
        return true;

    }


}
