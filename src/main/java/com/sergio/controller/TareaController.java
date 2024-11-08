package com.sergio.controller;

import com.sergio.dao.TareaDAO;
import com.sergio.dto.TareaDTO;
import com.sergio.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tarea")
public class TareaController {

    @Autowired
    TareaService tareaService;

    @Autowired
    TareaDAO tareaDAO;


//    @GetMapping()
//    public ResponseEntity<List<TareaDTO>> getTareas(){
//
//        List<TareaDTO> tareaDTOS =
//
//    }


}
