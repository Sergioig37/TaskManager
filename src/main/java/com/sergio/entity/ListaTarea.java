package com.sergio.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


import java.util.ArrayList;
import java.util.Set;

@Entity
@Getter
@Setter
public class ListaTarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario propietario;
    @ManyToOne(fetch = FetchType.EAGER)
    private Categoria categoria;
    @OneToMany(mappedBy = "lista", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<Tarea> tareas;

    @Override
    public String toString() {
        return "ListaTarea{" +
                "id=" + id +
                ", propietario=" + propietario +
                ", tareas=" + tareas +
                '}';
    }
}
