package br.edu.ifpb.tsi.duces_edu.model.usuario;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToMany;
import lombok.Data;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public abstract class Usuario {
    
    @Id
    @GeneratedValue()
    private UUID id;
    private String matricula;
    private String nome;
    private String fone;
    private String login;
    private String senha;
    private Boolean ativo;

    @ManyToMany
    private List<RoleUser> roles;

}
