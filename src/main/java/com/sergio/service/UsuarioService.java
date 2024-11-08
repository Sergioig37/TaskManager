package com.sergio.service;

import com.sergio.dao.UsuarioDAO;
import com.sergio.dto.UsuarioDTO;
import com.sergio.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UsuarioService {

    @Autowired
    UsuarioDAO usuarioDAO;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    GlobalService globalService;

    public List<UsuarioDTO> getAllUsers(){

        List<UsuarioDTO> usuarioDTOS = globalService.crearListDto(usuarioDAO.findAll(), UsuarioDTO.class);

        return usuarioDTOS;
    }

    public void crearUsuario(UsuarioDTO usuarioDTO){

        Usuario usuario = modelMapper.map(usuarioDTO, Usuario.class);


        usuarioDAO.save(usuario);

    }

    public UsuarioDTO editarUsuario(Long id,UsuarioDTO usuarioDTO){

        Optional<Usuario> usuario = usuarioDAO.findById(id);

        if(!usuario.isPresent()){
            return null;
        }

        modelMapper.map(usuarioDTO, usuario.get());

        usuarioDAO.save(usuario.get());

        return usuarioDTO;

    }

}
