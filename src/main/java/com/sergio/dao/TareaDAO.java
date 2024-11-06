package com.sergio.dao;

import com.sergio.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TareaDAO extends JpaRepository<Tarea, Long> {
}
