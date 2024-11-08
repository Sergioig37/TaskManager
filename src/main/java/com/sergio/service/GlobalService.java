package com.sergio.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GlobalService {


    @Autowired
    ModelMapper modelMapper;


    private <T, U> U mapToDto(T source, Class<U> targetClass) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(source, targetClass);
    }


    public <T, U> List<U> crearListDto(List<T> objectList, Class<U> targetClass) {

        List<U> objectListU = new ArrayList<>();

        for (T t : objectList) {
                U uObject = this.crearDto(t, targetClass);
                objectListU.add(uObject);
        }

        return objectListU;

    }

    private  <T, U> U crearDto(T source, Class<U> targetClass){

        U uObject = this.mapToDto(source, targetClass);

        return uObject;


    }

}
