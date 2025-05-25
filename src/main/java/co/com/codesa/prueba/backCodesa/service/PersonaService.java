package co.com.codesa.prueba.backCodesa.service;

import co.com.codesa.prueba.backCodesa.model.mysql.Persona;
import co.com.codesa.prueba.backCodesa.repository.mysql.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> getAllPersona(){
        return personaRepository.findAll();
    }

    public Persona postPersona(Persona persona){
        return personaRepository.save(persona);
    }

    public void deletePersona(Long id){
        personaRepository.deleteById(id);
    }

    public Optional<Persona> getPersonaById(Long id){
        return personaRepository.findById(id);
    }

    public Persona putPersona(Long id, Persona updatePersona) {
        return personaRepository.findById(id)
                .map(persona -> {
                    persona.setNombre(updatePersona.getNombre());
                    persona.setApellido(updatePersona.getApellido());
                    persona.setFechaNacimiento(updatePersona.getFechaNacimiento());
                    persona.setEmail(updatePersona.getEmail());
                    persona.setTelefono(updatePersona.getTelefono());
                    return personaRepository.save(persona);
                })
                .orElseThrow(() -> new RuntimeException("Persona no encontrada con id: " + id));
    }
}
