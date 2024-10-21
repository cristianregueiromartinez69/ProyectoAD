package com.cristian.bookmanage.registrousuarios.servicio;

import com.cristian.bookmanage.registrousuarios.dto.UsuarioRegistroDTO;
import com.cristian.bookmanage.registrousuarios.excepciones.EmailRegistroExcepcion;
import com.cristian.bookmanage.registrousuarios.excepciones.NombreRegistroExcepcion;
import com.cristian.bookmanage.registrousuarios.modelo.Usuarios;
import com.cristian.bookmanage.registrousuarios.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

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
    public Usuarios save(UsuarioRegistroDTO registroDTO) throws NombreRegistroExcepcion, EmailRegistroExcepcion {

        if(!authenticationRegisterName(registroDTO.getNombre())){
            throw new NombreRegistroExcepcion("Formato nombre incorrecto");
        }
        else if(!authenticationRegisterEmail(registroDTO.getEmail())){
            throw new EmailRegistroExcepcion("Formato email incorrecto");
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

    public boolean authenticationRegisterEmail(String email){

        return checkArobaEmailFirstLetter(email) && checkEmailHasAAroba(email) && checkEmailHasAArobaMoreThan1Time(email) &&
                checkPuntoEmailFirstLetter(email) && checkEmailHasAAPoint(email) && checkEmailHasAPointMoreThan1Time(email)
                 && checkStrangeThingInEmail(email) && checkDomainEmail(email);
    }

    /**
     * Método para comprobar autenticación de contraseña en registro de usuario
     * @param password la contraseña
     * @return true o false dependiendo de si la introduces bien o mal
     */
    public boolean authenticationRegisterPassword(String password){
        return checkLengthPassword(password) && checkPasswordHasStrangeThings(password) &&
                checkPaswordHasNumbers(password);
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
     * @param email el nombre que pasamos
     * @return True o False dependiendo del nombre
     */
    public boolean checkArobaEmailFirstLetter(String email){

        char aroba = '@';

        //hacemos un array de letras con el nombre
        char [] chars = email.toCharArray();

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
     * @param email el nombre a pasarle
     * @return True o False dependiendo del nombre que le pasemos
     */
    public boolean checkEmailHasAAroba(String email){

        //declaramos la variable char con el aroba y un array de letras del nombre a pasar
        char aroba = '@';
        char [] chars = email.toCharArray();

        //bucle para buscar el @
        for(char c : chars){

            //si la encuentra devuelve true
            if(c == aroba){
                return true;
            }

        }
        return false;
    }

    /**
     * Metodo para comprobar si el email lleva aroba más de 1 vez
     * @param email el nombre a pasarle
     * @return True o False dependiendo del nombre que le pasemos
     */
    public boolean checkEmailHasAArobaMoreThan1Time(String email){

        //declaramos la variable char con el aroba y un array de letras del nombre a pasar
        char aroba = '@';
        char [] chars = email.toCharArray();
        int contador = 0;

        //bucle para buscar el @
        for(char c : chars){

            //si la encuentra devuelve true
            if(c == aroba){
                contador++;
            }
            if(contador > 1){
                return false;
            }

        }
        return true;
    }

    /**
     * Metodo para comprobar si el email lleva o no lleva punto
     * @param email el nombre a pasarle
     * @return True o False dependiendo del nombre que le pasemos
     */
    public boolean checkEmailHasAAPoint(String email){

        //declaramos la variable char con el punto y un array de letras del nombre a pasar
        char punto = '.';
        char [] chars = email.toCharArray();

        //bucle para buscar el punto
        for(char c : chars){

            //si la encuentra devuelve true
            if(c == punto){
                return true;
            }

        }
        return false;
    }

    /**
     * Metodo que comprueba si la primera letra del email es un punto
     * @param email el nombre que pasamos
     * @return True o False dependiendo del nombre
     */
    public boolean checkPuntoEmailFirstLetter(String email){

        char punto = '.';

        //hacemos un array de letras con el nombre
        char [] chars = email.toCharArray();

        //comprobamos mediante un bucle si la primera letra es un punto, si es así devuelve false
        for(int i = 0; i < chars.length; i++){

            if(chars[0] == punto){
                return false;
            }
        }
        return true;

    }

    /**
     * Metodo para comprobar si el email lleva punto más de 1 vez
     * @param email el nombre a pasarle
     * @return True o False dependiendo del nombre que le pasemos
     */
    public boolean checkEmailHasAPointMoreThan1Time(String email){

        //declaramos la variable char con el punto y un array de letras del nombre a pasar
        char punto = '.';
        char [] chars = email.toCharArray();
        int contador = 0;

        //bucle para buscar el @
        for(char c : chars){

            //si la encuentra devuelve true
            if(c == punto){
                contador++;
            }
            if(contador > 1){
                return false;
            }

        }
        return true;
    }

    /**
     * Metodo que comprueba si se introducen caracteres extraños en el email
     * @param email el email a introducir
     * @return true o false dependiendo del email
     */
    public boolean checkStrangeThingInEmail(String email){

        //array de caracteres no permitidos en email
        char [] strangeCharacters = {' ', '!', '#', '$', '%', '^', '&', '*', '(', ')', '=', '[', ']',
        '<', '>', ',', '"', '/', ';', '?'};

        //pasamos a array de letras el email introducido
        char[] chars = email.toCharArray();
        for (char letra : chars) {

            //bucle anidado para comprobar si hay coincidencias de caracteres extraños
            for(char letraRara:strangeCharacters){
                if (letra == letraRara){
                    return false;
                }
            }

        }
        return true;
    }

    /**
     * Metodo para comprobar si un email tiene un dominio válido o no
     * @param email el email proporcionado
     * @return true o false dependiendo del email introducido
     */
    public boolean checkDomainEmail(String email){

        //array de Strings con los dominios más populares de emails
        String [] domains = {"@gmail.com", "@outlook.com","@hotmail.com","@yahoo.com","@icloud.com",
        "@zoho.com","@protonmail.com","@mail.com","@aol.com","@gmx.com","@yandex.com","@tutanota.com"};

        //bucle for para averiguar si coincide el email con los dominios
        for(int i = 0; i < domains.length; i++){
            if(email.endsWith(domains[i])){
                return true;
            }
        }

        return false;
    }


    /**
     * Método para comprobar si la contraseña del usuario tiene 12 o más caracteres
     * @param password la contraseña proporcionada
     * @return true o false si cumple los requisitios
     */
    public boolean checkLengthPassword(String password){

        return password.length() >= 12;
    }

    /**
     * Método para comprobar si la contraseña introducida tiene al menos 1 caracter especial
     * @param password la contraseña introducida
     * @return true o false dependiendo de la contraseña
     */
    public boolean checkPasswordHasStrangeThings(String password){
        //array con los caracteres especiales
        char[] caracteres = {'!', '|', '@', '"', '#', '·', '~', '$', '%', '€','¬','&','/','(',')','=','?','¿'
                ,'¡','<','>','+','-','*','^','[',']','¨','{','}',',',';',':','_','`','´'};

        //array de letras de la contraseña
        char [] passwordChars = password.toCharArray();

        //bucle for anidado para comprobar si hay coincidencias
        for(int i = 0; i < caracteres.length; i++){
            for(int j = 0; j < passwordChars.length; j++){
                if(passwordChars[j] == caracteres[i]){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Método para comprobar que la contraseña tiene al menos 1 número
     * @param password la contraseña introducida
     * @return true o false dependiendo de la contraseña proporcionada
     */
    public boolean checkPaswordHasNumbers(String password){

        //array de numeros
        char [] numbers = {'1','2','3','4','5','6','7','8','9','0'};

        //array de letras de la contraseña
        char [] passwordChars = password.toCharArray();

        //bucle anidado para comprobar la coincidencia
        for(int i = 0; i < numbers.length; i++){
            for(int j = 0; j < passwordChars.length; j++){
                if(numbers[i] == passwordChars[j]){
                    return true;
                }
            }
        }

        return false;
    }


}
