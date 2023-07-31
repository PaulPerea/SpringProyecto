package com.bolsadeideas.springboot.backend.apirest.models.dao;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Carreras;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarrerasDao extends JpaRepository<Carreras, Long> {
}
