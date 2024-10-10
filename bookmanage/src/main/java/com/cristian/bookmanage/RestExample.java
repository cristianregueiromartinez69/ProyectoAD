package com.cristian.bookmanage;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestExample.MAPPING)
public class RestExample {
    public static final String MAPPING = "/base";



    @Operation(summary = "metodo que te manda saludos jajaja")
    @PostMapping("/saudo")
    public String saudo(){
        return "Boas";
    }
}
