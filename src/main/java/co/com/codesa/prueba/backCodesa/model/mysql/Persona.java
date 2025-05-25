package co.com.codesa.prueba.backCodesa.model.mysql;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Persona")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Apellido")
    private String  apellido;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "FechaNacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "Email")
    private String email;

    @Column(name = "Telefono")
    private String telefono;

}
