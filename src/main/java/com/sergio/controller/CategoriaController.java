package com.sergio.controller;

import com.sergio.dao.CategoriaDAO;
import com.sergio.dto.CategoriaDTO;
import com.sergio.service.CategoriaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {


    //TODO: Acabar el controlador

    @Autowired
    CategoriaDAO categoriaDAO;

    @Autowired
    CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> getCategorias(){

        List<CategoriaDTO> categorias = categoriaService.getCategorias();

        return ResponseEntity.status(HttpStatus.OK).body(categorias);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategoria(@PathVariable Long id){

        categoriaDAO.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Categoria borrada con éxito");

    }

    @PostMapping("/save")
    public ResponseEntity<String> saveCategoria(@RequestBody CategoriaDTO categoriaDTO) {

        return ResponseEntity.status(HttpStatus.OK).body("Guardado con éxito");

    }

    @PutMapping("/edit/{id}")
    public  ResponseEntity<String> editCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO){

        CategoriaDTO categoria = categoriaService.editarCategoria(id, categoriaDTO);

        if(categoria==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontró la categoría");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Editado con éxito");

    }
}
