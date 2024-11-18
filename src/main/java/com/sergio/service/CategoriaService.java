package com.sergio.service;

import com.sergio.dao.CategoriaDAO;
import com.sergio.dto.CategoriaDTO;
import com.sergio.entity.Categoria;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaDAO categoriaDAO;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    GlobalService globalService;

    //TODO: Acabar service

    public List<CategoriaDTO> getCategorias() {

        List<CategoriaDTO> categorias = globalService.crearListDto(categoriaDAO.findAll(), CategoriaDTO.class);

        return categorias;

    }

    public CategoriaDTO editarCategoria(Long id, CategoriaDTO categoriaDTO) {

        Optional<Categoria> categoria = categoriaDAO.findById(id);

        if (categoria.isEmpty()) {
            return null;
        }

        modelMapper.map(categoriaDTO, categoria.get());

        categoriaDAO.save(categoria.get());

        return categoriaDTO;

    }

    public void crearCategoria(CategoriaDTO categoriaDTO){

        Categoria categoria = modelMapper.map(categoriaDTO, Categoria.class);

        categoriaDAO.save(categoria);

    }

}
