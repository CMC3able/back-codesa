package co.com.codesa.prueba.backCodesa.controller;

import co.com.codesa.prueba.backCodesa.model.mysql.Estudiante;
import co.com.codesa.prueba.backCodesa.model.mysql.Profesor;
import co.com.codesa.prueba.backCodesa.service.ProfesorService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/profesores")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;

    @GetMapping
    public List<Profesor> getAllProfesores(){
        return profesorService.getAllProfesores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Profesor>> getProfesorById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(profesorService.getProfesorById(id));
    }

    @PostMapping
    public ResponseEntity<Profesor> postProfesor(@RequestBody Profesor profesor) {
        Profesor nuevoProfesor = profesorService.postProfesor(profesor);
        if(nuevoProfesor == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProfesor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profesor> putProfesor(@PathVariable Long id, @RequestBody Profesor profesor) {
        return ResponseEntity.status(HttpStatus.OK).body(profesorService.putProfesor(id, profesor));
    }

    @DeleteMapping("/{id}")
    public void deleteProfesor(@PathVariable Long id) {
        profesorService.deleteProfesor(id);
    }
}
