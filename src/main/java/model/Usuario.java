package model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario")
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Integer usuarioId;

    @Column(name = "usuario_nome")
    private String usuarioNome;
    private String email;

    private LocalDate idade;

    @Enumerated(EnumType.STRING)
    private Sexo sexo;

 @ManyToMany@JoinTable(name = "usuario_pet",
 joinColumns = @JoinColumn(name = "usuario_id"),
 inverseJoinColumns = @JoinColumn(name = "pet_id"))
  private List<Pet> petList;

}
