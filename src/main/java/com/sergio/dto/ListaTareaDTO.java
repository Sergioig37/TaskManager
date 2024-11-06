package com.sergio.dto;

import com.sergio.entity.Tarea;
import com.sergio.entity.Usuario;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ListaTareaDTO  {

    private Long id;
    private Usuario propietario;
}
