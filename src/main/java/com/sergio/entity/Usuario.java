package com.sergio.entity;


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
@Table(name = "Usuario")
public class Usuario {


    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String correo;

    @OneToMany(mappedBy = "propietario", cascade = CascadeType.DETACH, orphanRemoval = true)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonManagedReference
    private Set<ListaTarea> listas;

    @OneToMany(mappedBy = "creador",  cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonManagedReference
    private Set<Categoria> categorias;

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
