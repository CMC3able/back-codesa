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
@Table(name = "CURSO")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String  descripcion;

    @Column(name = "CREDITOS")
    private Long creditos;

    @Column(name = "ID_PROFESOR")
    private Long idProfesor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PROFESOR", insertable = false, updatable = false)
    private Profesor profesor;
}
