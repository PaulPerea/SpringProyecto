package com.bolsadeideas.springboot.backend.apirest.Controllers;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Carreras;
import com.bolsadeideas.springboot.backend.apirest.models.services.ICarrerasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //para que sepa que es un controller
@RequestMapping("/api") //su url
public class CarrerasRestController {
    @Autowired
    private ICarrerasService iSedesService;

    @GetMapping("/carreras") //peticion get , mapear  la url a este endpoint
    public List<Carreras> index() {

        return iSedesService.findAll();
    }
}
