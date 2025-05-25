package co.com.codesa.prueba.backCodesa.service;

import co.com.codesa.prueba.backCodesa.model.mysql.Curso;
import co.com.codesa.prueba.backCodesa.model.mysql.Persona;
import co.com.codesa.prueba.backCodesa.model.mysql.Profesor;
import co.com.codesa.prueba.backCodesa.repository.mysql.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private ProfesorService profesorService;

    public List<Curso> getAllCurso(){
        return cursoRepository.findAll();
    }

    public Optional<Curso> getCursoById(Long id){
        return cursoRepository.findById(id);
    }

    public Curso postCurso(Curso curso){
        if (curso.getIdProfesor() <= 0) {
            return null;
        }
        Optional<Profesor> profesor = this.profesorService.getProfesorById(curso.getIdProfesor());
        if(profesor.isEmpty()){
            return null;
        }
        curso.setProfesor(profesor.get());
        return cursoRepository.save(curso);
    }

    public void deleteCurso(Long id) {
        cursoRepository.deleteById(id);
    }

    public Curso putCurso(Long id, Curso updateCurso){
        return cursoRepository.findById(id)
                .map(curso -> {
                    curso.setCreditos(updateCurso.getCreditos());
                    curso.setDescripcion(updateCurso.getDescripcion());
                    curso.setNombre(updateCurso.getNombre());
                    curso.setIdProfesor(updateCurso.getIdProfesor());
                    return cursoRepository.save(curso);
                })
                .orElseThrow(() -> new RuntimeException("Curso no encontrado con id: " + id));
    }
}
