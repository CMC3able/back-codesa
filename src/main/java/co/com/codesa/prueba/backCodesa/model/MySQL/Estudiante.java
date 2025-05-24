package co.com.codesa.prueba.backCodesa.model.MySQL;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ESTUDIANTE")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NUMERO_MATRICULA")
    private Long numeroMatricula;

    @Column(name = "GRADO")
    private String grado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID", insertable = false, updatable = false)
    private Persona persona;

}
