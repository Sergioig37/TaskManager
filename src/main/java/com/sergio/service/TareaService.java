package com.sergio.service;

import com.sergio.dao.TareaDAO;
import com.sergio.dto.TareaDTO;
import com.sergio.entity.Tarea;
import com.sergio.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    @Autowired
    TareaDAO tareaDAO;

    @Autowired
    GlobalService globalService;

    @Autowired
    ModelMapper modelMapper;

    public List<TareaDTO> getTareas(){

        List<TareaDTO> tareas = globalService.crearListDto(tareaDAO.findAll(), TareaDTO.class);


        return tareas;

    }

    public void crearTarea(TareaDTO tareaDTO){

        Tarea tarea = modelMapper.map(tareaDTO, Tarea.class);

        tareaDAO.save(tarea);
    }

    public TareaDTO editarTarea(Long id, TareaDTO tareaDTO){

        Optional<Tarea> tarea = tareaDAO.findById(id);

        if(tarea.isEmpty()){
            return null;
        }

        modelMapper.map(tareaDTO, tarea.get());

        tareaDAO.save(tarea.get());

        return tareaDTO;

    }

}
