package com.bolsadeideas.springboot.backend.apirest.models.services;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Sedes;

import java.util.List;

public interface ISedesService {
    public List<Sedes> findAll();

    public Sedes findById(Long id);

    public Sedes save(Sedes cliente);

    public void delete(Long id);
}
