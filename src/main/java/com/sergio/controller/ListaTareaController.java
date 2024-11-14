package com.sergio.controller;


import com.sergio.dao.ListaTareaDAO;
import com.sergio.dto.ListaTareaDTO;
import com.sergio.entity.ListaTarea;
import com.sergio.service.ListaTareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lista")
public class ListaTareaController {


    @Autowired
    ListaTareaDAO listaTareaDAO;

    @Autowired
    ListaTareaService listaTareaService;


    @GetMapping
    public ResponseEntity<List<ListaTareaDTO>> geListas(){

            List<ListaTareaDTO> listas = listaTareaService.getListas();

            return ResponseEntity.status(HttpStatus.OK).body(listas);

    }

    //TODO: Al eliminar las listas se tienen que eliminar todas las tareas que contenga también
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletwLista(@PathVariable Long id){

        listaTareaService.borrarLista(id);

        return ResponseEntity.status(HttpStatus.OK).body("Borrado con éxito");

    }

    @PostMapping("/save")
    public ResponseEntity<String> saveListas(@RequestBody ListaTareaDTO listaDT0){

        listaTareaService.crearLista(listaDT0);

        return ResponseEntity.status(HttpStatus.OK).body("Lista Guardada con éxito");

    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editLista(@PathVariable Long id, @RequestBody ListaTareaDTO listaDTO){

        ListaTareaDTO listaTarea = listaTareaService.editarTarea(id, listaDTO);

        if(listaTarea == null){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La lista no existe");

        }

        return ResponseEntity.status(HttpStatus.OK).body("Editado con éxito");

    }


}
