package co.com.codesa.prueba.backCodesa.model.mysql;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "Inscripcion")
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "IdEstudiante")
    private Long idEstudiante;

    @Column(name = "IdCurso")
    private Long idCurso;

    @Column(name = "FechaInscripcion")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaInscripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdEstudiante", insertable=false, updatable=false)
    private Estudiante estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdCurso",insertable=false, updatable=false)
    private Curso curso;
}
