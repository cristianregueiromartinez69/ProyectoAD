package com.cristian.bookmanage;

import com.cristian.bookmanage.registrousuarios.servicio.MongoConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase donde empieza a ejecutarse la aplicacion
 * @author cristian
 * @version 1.0
 */
@SpringBootApplication
public class BookManageApplication{

	@Autowired
	private MongoConnectionService mongoDBConnectionService;

	public static void main(String[] args) {
		SpringApplication.run(BookManageApplication.class, args);
	}


}
