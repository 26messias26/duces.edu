package br.edu.ifpb.tsi.duces_edu.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.edu.ifpb.tsi.duces_edu.model.usuario.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface AlunoRepository extends JpaRepository<Aluno,UUID>{

    Aluno findByLogin(String login);
    
}
