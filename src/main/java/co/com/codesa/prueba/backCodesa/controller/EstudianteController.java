package co.com.codesa.prueba.backCodesa.controller;

import co.com.codesa.prueba.backCodesa.model.mysql.Estudiante;
import co.com.codesa.prueba.backCodesa.service.EstudianteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudiantes")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public List<Estudiante> getAllEstudiantes(){
        return estudianteService.getAllEstudiantes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Estudiante>> getEstudianteById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(estudianteService.getEstudianteById(id));
    }

    @PostMapping
    public ResponseEntity<Estudiante> postEstudiante(@RequestBody Estudiante estudiante) {
        Estudiante nuevoEstudiante = estudianteService.postEstudiante(estudiante);
        if(nuevoEstudiante == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEstudiante);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estudiante> putEstudiante(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        return ResponseEntity.status(HttpStatus.OK).body(estudianteService.putEstudiante(id, estudiante));
    }

    @DeleteMapping("/{id}")
    public void deleteEstudiante(@PathVariable Long id) {
        estudianteService.deleteEstudiante(id);
    }
}
