package co.com.codesa.prueba.backCodesa.model.mysql;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "Estudiante")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "IdPersona")
    private Long idPersona;

    @Column(name = "NumeroMatricula")
    private Long numeroMatricula;

    @Column(name = "Grado")
    private String grado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdPersona", insertable=false, updatable=false)
    private Persona persona;

}
