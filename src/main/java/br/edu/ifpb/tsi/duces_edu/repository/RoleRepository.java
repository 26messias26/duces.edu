package br.edu.ifpb.tsi.duces_edu.repository;

import org.springframework.stereotype.Repository;

import br.edu.ifpb.tsi.duces_edu.model.usuario.RoleUser;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RoleRepository extends JpaRepository<RoleUser,Integer> {
    
}
