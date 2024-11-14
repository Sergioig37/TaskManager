package com.sergio.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Set;

@Entity
@Getter
@Setter
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    @JsonManagedReference
    private Set<ListaTarea> listas;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference
    private Usuario creador;


    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", listas=" + listas +
                ", creador=" + creador +
                '}';
    }
}
