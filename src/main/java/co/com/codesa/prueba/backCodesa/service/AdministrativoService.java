package co.com.codesa.prueba.backCodesa.service;

import co.com.codesa.prueba.backCodesa.model.mysql.Administrativo;
import co.com.codesa.prueba.backCodesa.model.mysql.Persona;
import co.com.codesa.prueba.backCodesa.repository.mysql.AdministrativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministrativoService {

    @Autowired
    private AdministrativoRepository administrativoRepository;
    @Autowired
    private PersonaService personaService;

    public List<Administrativo> getAllAdministrativos(){
        return administrativoRepository.findAll();
    }

    public Optional<Administrativo> getAdministrativoById(Long id){
        return administrativoRepository.findById(id);
    }

    public Administrativo postAdministrativo(Administrativo administrativo){
        if (administrativo.getIdPersona() <= 0) {
            return null;
        }
        Optional<Persona> persona = this.personaService.getPersonaById(administrativo.getIdPersona());
        if(persona.isEmpty()){
            return null;
        }
        administrativo.setPersona(persona.get());
        return administrativoRepository.save(administrativo);
    }

    public void deleteAdministrativo(Long id) {
        administrativoRepository.deleteById(id);
    }

    public Administrativo putAdministrativo(Long id, Administrativo updateAdministrativo){
        return administrativoRepository.findById(id)
                .map(administrativo -> {
                    administrativo.setCargo(updateAdministrativo.getCargo());
                    administrativo.setDepartamento(updateAdministrativo.getDepartamento());
                    return administrativoRepository.save(administrativo);
                })
                .orElseThrow(() -> new RuntimeException("Administrativo no encontrado con id: " + id));
    }
}
