package com.bolsadeideas.springboot.backend.apirest.models.entity;


import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@Entity
@Table(name = "carreras")
@Data
public class Carreras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carrera")
    private long id;
    private String nombre_carrera;
    private String descripcion;
    private long idSede;

    @ManyToOne
    @JoinColumn(name = "idSede", insertable = false, updatable = false)
    private Sedes objSede;
}

