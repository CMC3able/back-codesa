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
@Table(name = "Profesor")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "IdPersona")
    private Long idPersona;

    @Column(name = "Especialidad")
    private String especialidad;

    @Column(name = "FechaContratacion")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaContratacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdPersona", insertable=false, updatable=false)
    private Persona persona;
}
