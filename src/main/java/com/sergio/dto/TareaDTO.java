package com.sergio.dto;

import lombok.Data;

@Data
public class TareaDTO {

    private Long id;
    private String descripcion;
    private String categoria;
    private int prioridad;
}
