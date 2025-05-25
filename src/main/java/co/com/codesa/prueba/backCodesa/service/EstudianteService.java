package co.com.codesa.prueba.backCodesa.service;

import co.com.codesa.prueba.backCodesa.model.mysql.Estudiante;
import co.com.codesa.prueba.backCodesa.model.mysql.Persona;
import co.com.codesa.prueba.backCodesa.repository.mysql.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private PersonaService personaService;

    public List<Estudiante> getAllEstudiantes(){
        return estudianteRepository.findAll();
    }

    public Optional<Estudiante> getEstudianteById(Long id){
        return estudianteRepository.findById(id);
    }

    public Estudiante postEstudiante(Estudiante estudiante){
        if (estudiante.getIdPersona() <= 0) {
            return null;
        }
        Optional<Persona> persona = this.personaService.getPersonaById(estudiante.getIdPersona());
        if(persona.isEmpty()){
            return null;
        }
        estudiante.setPersona(persona.get());
        return estudianteRepository.save(estudiante);
    }

    public void deleteEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }

    public Estudiante putEstudiante(Long id, Estudiante updateEstudiante){
        return estudianteRepository.findById(id)
                .map(estudiante -> {
                    estudiante.setGrado(updateEstudiante.getGrado());
                    estudiante.setNumeroMatricula(updateEstudiante.getNumeroMatricula());
                    return estudianteRepository.save(estudiante);
                })
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado con id: " + id));
    }
}
