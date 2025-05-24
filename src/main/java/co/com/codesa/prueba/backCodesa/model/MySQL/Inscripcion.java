package co.com.codesa.prueba.backCodesa.model.MySQL;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "INSCRIPCION")
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "ID_ESTUDIANTE")
    private Long idEstudiante;

    @Column(name = "ID_CURSO")
    private Long idCurso;

    @Column(name = "FECHA_INSCRIPCION")
    private LocalDateTime fechaInscripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ESTUDIANTE", insertable = false, updatable = false)
    private Estudiante estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CURSO", insertable = false, updatable = false)
    private Curso curso;
}
