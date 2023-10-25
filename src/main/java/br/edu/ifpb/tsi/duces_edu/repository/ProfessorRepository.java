package br.edu.ifpb.tsi.duces_edu.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.edu.ifpb.tsi.duces_edu.model.usuario.Professor;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface ProfessorRepository extends JpaRepository<Professor,UUID>{

    Professor findByLogin(String login);
    
}
