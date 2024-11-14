package com.sergio.dto;

import com.sergio.entity.Categoria;
import com.sergio.entity.Tarea;
import com.sergio.entity.Usuario;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListaTareaDTO  {

    private Long id;
    private UsuarioDTO propietario;
    private CategoriaDTO categoria;
    private List<TareaDTO> tarea;

}
