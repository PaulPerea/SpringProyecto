package com.bolsadeideas.springboot.backend.apirest.models.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cursos")
@Data
public class Cursos implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
     private long id;
    @Column(name = "nombre_curso")
     private String nombre;
     private String descripcion;
     private long idCar;
     private long idCiclo;

    @ManyToOne
    @JoinColumn(name = "idCar", insertable = false, updatable = false)
    private Carreras objCarrera;

    @ManyToOne
    @JoinColumn(name = "idCiclo", insertable = false, updatable = false)
    private Ciclo objCiclo;
}
