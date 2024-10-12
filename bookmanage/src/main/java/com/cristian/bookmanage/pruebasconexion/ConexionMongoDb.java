package com.cristian.bookmanage.pruebasconexion;

import com.cristian.bookmanage.registrousuarios.dto.UsuarioRegistroDTO;
import com.cristian.bookmanage.registrousuarios.servicio.MongoConnectionService;

public class ConexionMongoDb {

    public static void main(String[]args){

        MongoConnectionService mongoConnectionService = new MongoConnectionService();
        UsuarioRegistroDTO u = new UsuarioRegistroDTO("roberto", "roberto@gmail.com", "1234");
        mongoConnectionService.save(u);
    }
}
