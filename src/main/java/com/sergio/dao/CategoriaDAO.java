package com.sergio.dao;

import com.sergio.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDAO extends JpaRepository<Categoria, Long> {
}
