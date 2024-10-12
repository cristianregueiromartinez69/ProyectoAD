package com.cristian.bookmanage;

import com.cristian.bookmanage.registrousuarios.servicio.MongoConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookManageApplication{

	@Autowired
	private MongoConnectionService mongoDBConnectionService;

	public static void main(String[] args) {
		SpringApplication.run(BookManageApplication.class, args);
	}


}
