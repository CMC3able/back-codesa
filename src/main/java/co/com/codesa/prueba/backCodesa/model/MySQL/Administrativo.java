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
@Table(name = "ADMINISTRATIVO")
public class Administrativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CARGO")
    private String cargo;

    @Column(name = "DEPARTAMENTO")
    private String departamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID", insertable = false, updatable = false)
    private Persona persona;
}
