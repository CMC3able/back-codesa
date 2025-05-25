package co.com.codesa.prueba.backCodesa.controller;

import co.com.codesa.prueba.backCodesa.model.mysql.Administrativo;
import co.com.codesa.prueba.backCodesa.model.mysql.Estudiante;
import co.com.codesa.prueba.backCodesa.service.AdministrativoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/administrativo")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class AdministrativoController {

    @Autowired
    private AdministrativoService administrativoService;

    @GetMapping
    public List<Administrativo> getAllAdministrativos(){
        return administrativoService.getAllAdministrativos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Administrativo>> getAdministrativoById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(administrativoService.getAdministrativoById(id));
    }

    @PostMapping
    public ResponseEntity<Administrativo> postAdministrativo(@RequestBody Administrativo administrativo) {
        Administrativo nuevoAdministrativo = administrativoService.postAdministrativo(administrativo);
        if(nuevoAdministrativo == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoAdministrativo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrativo> putAdministrativo(@PathVariable Long id, @RequestBody Administrativo administrativo) {
        return ResponseEntity.status(HttpStatus.OK).body(administrativoService.putAdministrativo(id, administrativo));
    }

    @DeleteMapping("/{id}")
    public void deleteAdministrativo(@PathVariable Long id) {
        administrativoService.deleteAdministrativo(id);
    }
}
