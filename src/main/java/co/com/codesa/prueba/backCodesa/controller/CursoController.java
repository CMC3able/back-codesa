package co.com.codesa.prueba.backCodesa.controller;

import co.com.codesa.prueba.backCodesa.model.mysql.Administrativo;
import co.com.codesa.prueba.backCodesa.model.mysql.Curso;
import co.com.codesa.prueba.backCodesa.service.CursoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curso")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> getAllCurso(){
        return cursoService.getAllCurso();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Curso>> getCursoById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.getCursoById(id));
    }

    @PostMapping
    public ResponseEntity<Curso> postCurso(@RequestBody Curso curso) {
        Curso nuevoCurso = cursoService.postCurso(curso);
        if(nuevoCurso == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCurso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso>  putCurso(@PathVariable Long id, @RequestBody Curso curso) {
        return ResponseEntity.status(HttpStatus.OK).body(cursoService.putCurso(id, curso));
    }

    @DeleteMapping("/{id}")
    public void deleteCurso(@PathVariable Long id) {
        cursoService.deleteCurso(id);
    }
}
