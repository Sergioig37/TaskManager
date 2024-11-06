package com.sergio.controller;

import com.sergio.dao.UsuarioDAO;
import com.sergio.dto.UsuarioDTO;
import com.sergio.entity.Usuario;
import com.sergio.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    UsuarioDAO usuarioDAO;

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> getUsers(){

        List<UsuarioDTO> usuarios =  usuarioService.crearListDTO(usuarioDAO.findAll());

        System.out.println("Pasando");

        return ResponseEntity.status(HttpStatus.OK).body(usuarios);
    }

}
