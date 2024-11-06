package com.sergio.service;

import com.sergio.dao.UsuarioDAO;
import com.sergio.dto.UsuarioDTO;
import com.sergio.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class UsuarioService {

    @Autowired
    UsuarioDAO usuarioDAO;
    @Autowired
    ModelMapper modelMapper;

    public List<UsuarioDTO> getAllUsers(){

        List<UsuarioDTO> usuarioDTOS = this.crearListDTO(usuarioDAO.findAll());

        return usuarioDTOS;
    }

    public List<UsuarioDTO> crearListDTO(List<Usuario> usuarios){

        List<UsuarioDTO> usuariosDTO = new ArrayList<>();

        for(Usuario usuario: usuarios){
            usuariosDTO.add(this.crearDTO(usuario));
        }

        return usuariosDTO;
    }

    private UsuarioDTO crearDTO(Usuario usuario){
        UsuarioDTO usuarioDto = modelMapper.map(usuario, UsuarioDTO.class);

        return usuarioDto;
    }
}
