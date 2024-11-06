package com.sergio.service;

import com.sergio.dao.CategoriaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    CategoriaDAO categoriaDAO;

}
