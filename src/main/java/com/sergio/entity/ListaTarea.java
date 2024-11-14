package com.sergio.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class ListaTarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Usuario propietario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Categoria categoria;
    @OneToMany(mappedBy = "lista", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonManagedReference
    private List<Tarea> tareas;

    @Override
    public String toString() {
        return "ListaTarea{" +
                "id=" + id +
                ", propietario=" + propietario.getUsername() +
                ", tareas=" + tareas +
                '}';
    }
}
