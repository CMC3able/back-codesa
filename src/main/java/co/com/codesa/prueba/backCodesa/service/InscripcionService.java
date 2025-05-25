package co.com.codesa.prueba.backCodesa.service;

import co.com.codesa.prueba.backCodesa.model.mysql.Curso;
import co.com.codesa.prueba.backCodesa.model.mysql.Estudiante;
import co.com.codesa.prueba.backCodesa.model.mysql.Inscripcion;
import co.com.codesa.prueba.backCodesa.model.mysql.Persona;
import co.com.codesa.prueba.backCodesa.repository.mysql.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscripcionService {
    @Autowired
    private InscripcionRepository inscripcionRepository;
    @Autowired
    private EstudianteService estudianteService;
    @Autowired
    private CursoService cursoService;

    public List<Inscripcion> getAllInscripciones(){
        return inscripcionRepository.findAll();
    }

    public Optional<Inscripcion> getInscripcionById(Long id){
        return inscripcionRepository.findById(id);
    }

    public Inscripcion postInscripcion(Inscripcion inscripcion){
        if (inscripcion.getIdEstudiante() <= 0) {
            return null;
        }
        if (inscripcion.getIdCurso() <= 0) {
            return null;
        }
        Optional<Estudiante> estudiante = this.estudianteService.getEstudianteById(inscripcion.getIdEstudiante());
        if(estudiante.isEmpty()){
            return null;
        }
        inscripcion.setEstudiante(estudiante.get());
        Optional<Curso> curso = this.cursoService.getCursoById(inscripcion.getIdCurso());
        if(curso.isEmpty()){
            return null;
        }
        inscripcion.setCurso(curso.get());
        return inscripcionRepository.save(inscripcion);
    }

    public void deleteInscripcion(Long id) {
        inscripcionRepository.deleteById(id);
    }

    public Inscripcion putInscripcion(Long id, Inscripcion updateInscripcion){
        return inscripcionRepository.findById(id)
                .map(inscripcion -> {
                    inscripcion.setFechaInscripcion(updateInscripcion.getFechaInscripcion());
                    inscripcion.setIdCurso(updateInscripcion.getIdCurso());
                    inscripcion.setIdEstudiante(updateInscripcion.getIdEstudiante());
                    return inscripcionRepository.save(inscripcion);
                })
                .orElseThrow(() -> new RuntimeException("Inscripcion no encontrado con id: " + id));
    }
}
