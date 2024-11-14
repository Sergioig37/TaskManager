package com.sergio.controller;

import com.sergio.dao.TareaDAO;
import com.sergio.dto.TareaDTO;
import com.sergio.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarea")
public class TareaController {

    @Autowired
    TareaService tareaService;

    @Autowired
    TareaDAO tareaDAO;


    @GetMapping()
    public ResponseEntity<List<TareaDTO>> getTareas(){

        List<TareaDTO> tareaDTOS = tareaService.getTareas();

        return ResponseEntity.status(HttpStatus.OK).body(tareaDTOS);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTarea(@PathVariable Long id){

        tareaDAO.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Borrado con éxito");

    }

    @PostMapping("/post")
    public ResponseEntity<String> saveTarea(@RequestBody TareaDTO tareaDTO){

        tareaService.crearTarea(tareaDTO);

        return ResponseEntity.status(HttpStatus.OK).body("Creado correctamente");



    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editTarea(@PathVariable Long id, @RequestBody TareaDTO tareaDTO){

        TareaDTO tarea = tareaService.editarTarea(id, tareaDTO);

        if(tarea == null){

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoría no encontrada");

        }

        return ResponseEntity.status(HttpStatus.OK).body("Editado correctamente");

    }
}
