package com.bolsadeideas.springboot.backend.apirest.Controllers;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Carreras;
import com.bolsadeideas.springboot.backend.apirest.models.services.ICarrerasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController //para que sepa que es un controller
@RequestMapping("/api") //su url
public class CarrerasRestController {
    @Autowired
    private ICarrerasService iCarrerasService;

    @GetMapping("/carreras") //peticion get , mapear  la url a este endpoint
    public List<Carreras> index() {

        return iCarrerasService.findAll();
    }
    @GetMapping("/carreras/{id}")
    public ResponseEntity<?> show(@PathVariable Long id){
        Carreras carreras = null;
        Map<String,Object> response = new HashMap<>();
        try {
            carreras = iCarrerasService.findById(id);
        }catch (DataAccessException e){
            response.put("mensaje","Error al realizar la consulata en la base de datos");
            response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (carreras == null){
            response.put("mensaje","La Carrera ID: ".concat(id.toString().concat(" no existe en la base de datos")));
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Carreras>(carreras,HttpStatus.OK);
    }
    @PostMapping("/carrerasSave")
    public ResponseEntity<?>create (@Valid @RequestBody Carreras carreras, BindingResult result){
        Carreras carreraNew = null;
        Map<String, Object> response = new HashMap<>();
        if(result.hasErrors()){
            List<String> errors = result.getFieldErrors().stream().
                    map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage()).
                    collect(Collectors.toList());
            response.put("errors",errors);
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.BAD_REQUEST);
        }
        try {
            carreraNew = iCarrerasService.save(carreras);
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "La sede ha sido creado con éxito : ");
        response.put("Carrera", carreraNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    @PutMapping("/carreraActualizar/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Carreras carrera, BindingResult result,@PathVariable Long id){
        Carreras CarActual = iCarrerasService.findById(id);
        Carreras CarUpdate = null;

        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()){
            List<String> errors = result.getFieldErrors().stream().
                    map(err -> "El campo '" + err.getDefaultMessage() + "' " + err.getDefaultMessage()).
                    collect(Collectors.toList());
            response.put("errors",errors);
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.BAD_REQUEST);
        }
        if (CarActual==null){
            response.put("mensaje","Error no se pudo, editar la carrera ID: ".concat(id.toString().concat(" no existe en la base de datos")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return null;
    }
}
