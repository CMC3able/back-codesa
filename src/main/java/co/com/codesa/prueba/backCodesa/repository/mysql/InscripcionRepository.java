package co.com.codesa.prueba.backCodesa.repository.mysql;

import co.com.codesa.prueba.backCodesa.model.mysql.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
}
