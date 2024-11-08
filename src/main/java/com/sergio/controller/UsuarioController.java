package com.sergio.controller;

import com.sergio.dao.UsuarioDAO;
import com.sergio.dto.UsuarioDTO;
import com.sergio.entity.Usuario;
import com.sergio.service.UsuarioService;
import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

    @DeleteMapping("/delete/{idUser}")
    public ResponseEntity<String> deleteUser(@PathVariable Long idUser){

        usuarioDAO.deleteById(idUser);

        return ResponseEntity.status(HttpStatus.OK).body("Usuario borrado correctamente");

    }

    @PostMapping("/post")
    public ResponseEntity<String> saveUser(@RequestBody UsuarioDTO usuarioDTO){

            usuarioService.crearUsuario(usuarioDTO);

            return ResponseEntity.status(HttpStatus.OK).body("Usuario creado correctamente");

    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editUser(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDtoEdit){

            UsuarioDTO usuarioUpdated = usuarioService.editarUsuario(id, usuarioDtoEdit);

            if(usuarioUpdated == null)
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no existe");
            }

            return ResponseEntity.status(HttpStatus.OK).body("Editado correctamente");

    }

}
