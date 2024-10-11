package com.cristian.bookmanage.registrousuarios.controlador;

import com.cristian.bookmanage.registrousuarios.dto.UsuarioRegistroDTO;
import com.cristian.bookmanage.registrousuarios.servicio.UsuarioServicio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registro")
public class UsuarioRegistroControlador {

    private UsuarioServicio usuarioServicio;

    public UsuarioRegistroControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO(){
        return new UsuarioRegistroDTO();
    }

    @GetMapping
    public String mostrarFormularioRegistro(){

        return "registro";
    }

    @PostMapping
    public String registrarCuentaUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO){

        usuarioServicio.save(registroDTO);
        return "redirect:registro?exito";
    }
}
