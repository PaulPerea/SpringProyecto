package com.bolsadeideas.springboot.backend.apirest.Controllers;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Sedes;
import com.bolsadeideas.springboot.backend.apirest.models.services.ISedesService;
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

@RestController
@RequestMapping("/api")
public class SedeRestController {
    @Autowired
    private ISedesService iSedesService;

    @GetMapping("/sedes") //peticion get , mapear  la url a este endpoint
    public List<Sedes> index() {
        return iSedesService.findAll();
    }
    @GetMapping("/sedes/{id}")
    public ResponseEntity<?> show(@PathVariable Long id){

        Sedes sedes = null;
        Map<String, Object> response = new HashMap<>();

        try {
            sedes = iSedesService.findById(id);
        } catch (DataAccessException e){
            response.put("mensaje", "Error al realizar la consulta en la base de datos") ;
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (sedes == null){
            response.put("mensaje", "La Sede ID: ".concat(id.toString().concat(" no existe en la base de datos")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Sedes>(sedes, HttpStatus.OK);
    }
    @PostMapping("/sedesSave")
    public ResponseEntity<?> create(@Valid @RequestBody Sedes sedes, BindingResult result){
        Sedes clienteNew = null;
        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()){
            List<String> errors = result.getFieldErrors().stream().
                    map(err ->  "El campo '" + err.getField() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors",errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST); //estado 400
        }
        try {
            clienteNew = iSedesService.save(sedes);
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar insert en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "La sede ha sido creado con éxito : ");
        response.put("Sede", clienteNew);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    @PutMapping("/sedeActualizar/{id}")
    public ResponseEntity<?>create(@Valid @RequestBody Sedes sedes, BindingResult result, @PathVariable Long id){
        Sedes SedeActual = iSedesService.findById(id);
        Sedes SedeUpdated = null;

        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()){
            List<String> errors = result.getFieldErrors().stream().
                    map(err ->  "El campo '" + err.getDefaultMessage() + "' " + err.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("errors",errors);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
        }
        if (SedeActual == null) {
            response.put("mensaje", "Error, no se pudo, editar la sede ID: ".concat(id.toString().concat(" no existe en la base de datos")));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try {
            SedeActual.setNombre_sede(sedes.getNombre_sede());
            SedeActual.setDireccion(sedes.getDireccion());
            SedeActual.setTelefono(sedes.getTelefono());

            SedeUpdated = iSedesService.save(SedeActual);

        } catch (DataAccessException e){
            response.put("mensaje", "Error al realizar al actualizar la Sede en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "La Sede ha sido actualizado con éxito");
        response.put("Sede", SedeUpdated);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }
    @DeleteMapping("/sedes/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Map<String, Object> response = new HashMap<>();
        try {
            iSedesService.delete(id);
        } catch (DataAccessException e){
            response.put("mensaje", "Error al eliminar la sede en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje","La sede eliminado con exito");
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
    }
}
