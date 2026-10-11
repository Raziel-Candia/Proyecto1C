package mx.edu.utez.Proyecto1C.model.direccion;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.Proyecto1C.model.persona.Persona;

@Entity
@Table(name = "dirreciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String calle;
    private String colonia;
    private String municipio;
    private String estado;
    private String numero;
    private String codigoPostal;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

}
