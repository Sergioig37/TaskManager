package com.sergio.service;

import com.sergio.dao.TareaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaService {

    @Autowired
    TareaDAO tareaDAO;



}
