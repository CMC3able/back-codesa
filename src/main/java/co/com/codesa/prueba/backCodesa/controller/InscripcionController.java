package co.com.codesa.prueba.backCodesa.controller;

import co.com.codesa.prueba.backCodesa.model.mysql.Estudiante;
import co.com.codesa.prueba.backCodesa.model.mysql.Inscripcion;
import co.com.codesa.prueba.backCodesa.service.InscripcionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inscripcion")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @GetMapping
    public List<Inscripcion> getAllInscripcion(){
        return inscripcionService.getAllInscripciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Inscripcion>> getInscripcionById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(inscripcionService.getInscripcionById(id));
    }

    @PostMapping
    public ResponseEntity<Inscripcion>  postInscripcion(@RequestBody Inscripcion inscripcion) {
        Inscripcion nuevoInscripcion = inscripcionService.postInscripcion(inscripcion);
        if(nuevoInscripcion == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoInscripcion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Inscripcion>  putInscripcion(@PathVariable Long id, @RequestBody Inscripcion inscripcion) {
        return ResponseEntity.status(HttpStatus.OK).body(inscripcionService.putInscripcion(id, inscripcion));
    }

    @DeleteMapping("/{id}")
    public void deleteInscripcion(@PathVariable Long id) {
        inscripcionService.deleteInscripcion(id);
    }
}
