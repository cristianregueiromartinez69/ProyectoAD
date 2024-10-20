package com.cristian.bookmanage.registrousuarios.servicio;

import com.cristian.bookmanage.registrousuarios.dto.UsuarioRegistroDTO;
import com.cristian.bookmanage.registrousuarios.excepciones.NombreRegistroExcepcion;
import com.cristian.bookmanage.registrousuarios.modelo.Usuarios;
import com.cristian.bookmanage.registrousuarios.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;

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
    public Usuarios save(UsuarioRegistroDTO registroDTO) throws NombreRegistroExcepcion {

        if(!authenticationRegisterName(registroDTO.getNombre())){
            throw new NombreRegistroExcepcion("Formato nombre incorrecto");
        }
        else{
            Usuarios usuario = new Usuarios(registroDTO.getId(),
                    registroDTO.getNombre(), registroDTO.getEmail(),
                    registroDTO.getPassword());

            //llamamos al metodo del repositorio que guarda los usuarios en la base de datos
            return usuarioRepositorio.save(usuario);
        }
    }

    /**
     * Método que engloba a los metodos de autenticación de nombre al registrarse en la pagina web
     * @param name el nombre a pasar
     * @return True o False dependiendo del nombre introducido
     */
    public boolean authenticationRegisterName(String name){

        return lengthUserName(name) && isDigitUserName(name) && strangeCharactersUsername(name);
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

    /**
     * Método para comprobar que no se introducen numeros en el nombre de una persona
     * @param name el nombre a introducir
     * @return True o False dependiendo del nombre que introdujeras
     */
    public boolean isDigitUserName(String name) {

        //se realiza un array de chars con los numeros y un array de chars con el string
        char[] numeros = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] chars = name.toCharArray();
        //con un bucle recorremos el array de letras y con otro anidado el de numeros
        for (char letra : chars) {

            //si alguna letra coincide con un numero, el metodo devuelve false
            for(char numero:numeros){
                if (letra == numero){
                    return false;
                }
            }

        }
        return true;

    }

    /**
     * Método para comprobar que no se introducen carácteres extraños en los nombres de registro
     * @param name el nombre que vas a introducir
     * @return True o False dependiendo del nombre introducido
     */
    public boolean strangeCharactersUsername(String name){
        //mismo procedimiento que en el método anterior pero con caracteres extraños
        char[] caracteres = {'!', '|', '@', '"', '#', '·', '~', '$', '%', '€','¬','&','/','(',')','=','?','¿'
        ,'¡','º','ª','<','>','+','-','*','^','[',']','¨','{','}',',',';',':','_','`','´'};
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

    /**
     * Metodo que comprueba si la primera letra del email es un @
     * @param name el nombre que pasamos
     * @return True o False dependiendo del nombre
     */
    public boolean checkArobaEmailFirstLetter(String name){

        char aroba = '@';

        //hacemos un array de letras con el nombre
        char [] chars = name.toCharArray();

        //comprobamos mediante un bucle si la primera letra es un @, si es así devuelve false
        for(int i = 0; i < chars.length; i++){

            if(chars[0] == aroba){
                return false;
            }
        }
        return true;

    }


    /**
     * Metodo para comprobar si el email lleva o no lleva aroba
     * @param name el nombre a pasarle
     * @return True o False dependiendo del nombre que le pasemos
     */
    public boolean checkEmailHasAAroba(String name){

        //declaramos la variable char con el aroba y un array de letras del nombre a pasar
        char aroba = '@';
        char [] chars = name.toCharArray();

        //bucle para buscar el @
        for(char c : chars){

            //si la encuentra devuelve true
            if(c == aroba){
                return true;
            }

        }
        return false;
    }


}
