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
@Table(name = "Curso")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Descripcion")
    private String  descripcion;

    @Column(name = "Creditos")
    private Long creditos;

    @Column(name = "IdProfesor")
    private Long idProfesor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdProfesor", insertable=false, updatable=false)
    private Profesor profesor;
}
