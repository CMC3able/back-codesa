package co.com.codesa.prueba.backCodesa.controller;

import co.com.codesa.prueba.backCodesa.model.mysql.Persona;
import co.com.codesa.prueba.backCodesa.service.PersonaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persona")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public List<Persona> getAllPersona(){
        return personaService.getAllPersona();
    }

    @PostMapping
    public ResponseEntity<Persona> postPersona(@RequestBody Persona persona){
        return ResponseEntity.status(HttpStatus.OK).body(personaService.postPersona(persona));
    }

    @DeleteMapping("/{id}")
    public void deletePersona(@PathVariable Long id){
        personaService.deletePersona(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Persona>> getPersonaById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(personaService.getPersonaById(id));
    }

    @PutMapping("/{id}")
    public Persona putPersona(@PathVariable Long id, @RequestBody Persona persona) {
        return personaService.putPersona(id, persona);
    }
}
