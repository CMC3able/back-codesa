package co.com.codesa.prueba.backCodesa.service;

import co.com.codesa.prueba.backCodesa.model.mysql.Persona;
import co.com.codesa.prueba.backCodesa.model.mysql.Profesor;
import co.com.codesa.prueba.backCodesa.repository.mysql.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;
    @Autowired
    private PersonaService personaService;

    public List<Profesor> getAllProfesores(){
        return profesorRepository.findAll();
    }

    public Optional<Profesor> getProfesorById(Long id){
        return profesorRepository.findById(id);
    }

    public Profesor postProfesor(Profesor profesor){
        if (profesor.getIdPersona() <= 0) {
            return null;
        }
        Optional<Persona> persona = this.personaService.getPersonaById(profesor.getIdPersona());
        if(persona.isEmpty()){
            return null;
        }
        profesor.setPersona(persona.get());
        return profesorRepository.save(profesor);
    }

    public void deleteProfesor(Long id) {
        profesorRepository.deleteById(id);
    }

    public Profesor putProfesor(Long id, Profesor updateProfesor){
        return profesorRepository.findById(id)
                .map(profesor -> {
                    profesor.setEspecialidad(updateProfesor.getEspecialidad());
                    profesor.setFechaContratacion(updateProfesor.getFechaContratacion());
                    return profesorRepository.save(profesor);
                })
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado con id: " + id));
    }
}
