package com.bolsadeideas.springboot.backend.apirest.models.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity //para saber que estamos utilizando jpa
@Table(name = "sedes")
@Data
public class Sedes implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_sede;
    @Column(nullable = false, unique = true )
    @NotEmpty(message = "no puede estar vacio")
    private String nombre_sede;
    private String direccion;
    private String telefono;


    private static final long serialVersionUID = 1L;
}
