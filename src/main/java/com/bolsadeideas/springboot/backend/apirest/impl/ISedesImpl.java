package com.bolsadeideas.springboot.backend.apirest.impl;

import com.bolsadeideas.springboot.backend.apirest.models.dao.ISedesDao;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Sedes;
import com.bolsadeideas.springboot.backend.apirest.models.services.ISedesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ISedesImpl implements ISedesService {
    @Autowired
    private ISedesDao sedesDao;

    @Override
    @Transactional(readOnly = true)
    public List<Sedes> findAll() {
        return (List<Sedes>) sedesDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Sedes findById(Long id) {
        return sedesDao.findById(id).orElse(null);
    }

    @Override
    public Sedes save(Sedes sedes) {
        return sedesDao.save(sedes);
    }

    @Override
    public void delete(Long id) {
        sedesDao.deleteById(id);
    }
}
