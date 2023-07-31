package com.bolsadeideas.springboot.backend.apirest.models.services;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Carreras;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Sedes;

import java.util.List;

public interface ICarrerasService {
    public List<Carreras> findAll();

    public Carreras findById(Long id);

    public Carreras save(Carreras carreras);

    public void delete(Long id);
}
