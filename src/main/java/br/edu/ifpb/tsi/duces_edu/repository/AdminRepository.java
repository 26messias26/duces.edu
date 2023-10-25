package br.edu.ifpb.tsi.duces_edu.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.edu.ifpb.tsi.duces_edu.model.usuario.Admin;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface AdminRepository extends JpaRepository<Admin,UUID>{

    Admin findByLogin(String login);
    
}
