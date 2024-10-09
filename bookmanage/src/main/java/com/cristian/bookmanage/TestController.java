package com.cristian.bookmanage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RestController
public class TestController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/test-db")
    public String testDbConnection() {
        try (Connection connection = dataSource.getConnection()) {
            return "Conexión a la base de datos exitosa!";
        } catch (SQLException e) {
            return "Error de conexión: " + e.getMessage();
        }
    }
}

