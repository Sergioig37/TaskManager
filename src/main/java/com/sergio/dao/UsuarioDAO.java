package com.sergio.dao;

import com.sergio.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuarioDAO extends JpaRepository<Usuario, Long> {

}
