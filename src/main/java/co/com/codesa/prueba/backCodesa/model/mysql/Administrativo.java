package co.com.codesa.prueba.backCodesa.model.mysql;

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
@Table(name = "Administrativo")
public class Administrativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "IdPersona")
    private Long idPersona;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "Departamento")
    private String departamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdPersona", insertable=false, updatable=false)
    private Persona persona;
}
