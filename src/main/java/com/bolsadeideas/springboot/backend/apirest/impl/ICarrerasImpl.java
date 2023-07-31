package com.bolsadeideas.springboot.backend.apirest.impl;

import com.bolsadeideas.springboot.backend.apirest.models.dao.ICarrerasDao;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Carreras;
import com.bolsadeideas.springboot.backend.apirest.models.services.ICarrerasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ICarrerasImpl implements ICarrerasService {
    @Autowired
    private ICarrerasDao carrerasDao;

    @Override
    @Transactional(readOnly = true)
    public List<Carreras> findAll() {
        return (List<Carreras>) carrerasDao.findAll();
    }

    @Override
    public Carreras findById(Long id) {
        return null;
    }

    @Override
    public Carreras save(Carreras carreras) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
