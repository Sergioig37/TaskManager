package com.sergio.dao;

import com.sergio.entity.ListaTarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListaTareaDAO extends JpaRepository<ListaTarea, Long> {
}
