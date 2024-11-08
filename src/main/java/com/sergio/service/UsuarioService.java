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

    public List<UsuarioDTO> getAllUsers(){

        List<UsuarioDTO> usuarioDTOS = this.crearListDTO(usuarioDAO.findAll());

        return usuarioDTOS;
    }

    public void crearUsuario(UsuarioDTO usuarioDTO){

        Usuario usuario =  new Usuario();

        usuario.setCorreo(usuarioDTO.getCorreo());
        usuario.setUsername(usuarioDTO.getUsername());
        usuario.setPassword(usuarioDTO.getPassword());

        usuarioDAO.save(usuario);

    }

    public List<UsuarioDTO> crearListDTO(List<Usuario> usuarios){

        List<UsuarioDTO> usuariosDTO = new ArrayList<>();

        for(Usuario usuario: usuarios){
            usuariosDTO.add(this.crearDTO(usuario));
        }

        return usuariosDTO;
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

    private UsuarioDTO crearDTO(Usuario usuario){
        UsuarioDTO usuarioDto = modelMapper.map(usuario, UsuarioDTO.class);

        return usuarioDto;
    }


}
