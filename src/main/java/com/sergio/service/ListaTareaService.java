package com.sergio.service;

import com.sergio.dao.CategoriaDAO;
import com.sergio.dao.ListaTareaDAO;
import com.sergio.dao.UsuarioDAO;
import com.sergio.dto.ListaTareaDTO;
import com.sergio.dto.TareaDTO;
import com.sergio.entity.Categoria;
import com.sergio.entity.ListaTarea;
import com.sergio.entity.Tarea;
import com.sergio.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ListaTareaService {

    @Autowired
    ListaTareaDAO listaDAO;

    @Autowired
    GlobalService globalService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UsuarioDAO usuarioDAO;

    @Autowired
    CategoriaDAO categoriaDAO;

    public List<ListaTareaDTO> getListas() {

        List<ListaTareaDTO> listas = globalService.crearListDto(listaDAO.findAll(), ListaTareaDTO.class);

        return listas;
    }

    //TODO: Los usuarios podrán elegir una categoría existente (o crear una nueva) al momento de crear
    //TODO: una nueva lista, todo lo demás se tendrá que añadir después de la creación
    public void crearLista(ListaTareaDTO listaTareaDTO) {

        ListaTarea lista = modelMapper.map(listaTareaDTO, ListaTarea.class);

        listaDAO.save(lista);

    }

    //Editar las listas implica dos cosas
    //1: Borrar tareas
    //2: Cambiar Categorías º
    public ListaTareaDTO editarTarea(Long id, ListaTareaDTO listaTareaDTO, Long categoria) {

        Optional<ListaTarea> lista = listaDAO.findById(id);


        if (lista.isEmpty()) {
            return null;
        }
        if(categoria != null){
            Optional<Categoria> newCategoria = categoriaDAO.findById(categoria);
            lista.get().setCategoria(newCategoria.get());
            newCategoria.get().getListas().remove(lista.get());
            newCategoria.get().getListas().add(lista.get());
        }

        modelMapper.map(listaTareaDTO, lista.get());


        listaDAO.save(lista.get());

        return listaTareaDTO;

    }

    public void borrarLista(Long id) {
        Optional<ListaTarea> lista = listaDAO.findById(id);

        if (lista.isPresent()) {
            listaDAO.deleteById(id);
        }
    }

}

