package br.edu.ifpb.tsi.duces_edu.model.usuario;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public abstract class Usuario {
    
    @Id
    @GeneratedValue
    private UUID id;
    private String matricula;

    @NotBlank(message="Campo obrigatório")
    @NotNull
    private String nome;
    
    private String fone;
    
    @NotBlank(message="Campo obrigatório")
    @NotNull
    private String login;
    
    @NotBlank(message="Campo obrigatório")
    @NotNull
    private String senha;

    private Boolean ativo;

    @ManyToMany
    private List<RoleUser> roles;

}
