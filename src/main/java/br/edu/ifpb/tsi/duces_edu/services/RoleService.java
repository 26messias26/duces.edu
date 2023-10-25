package br.edu.ifpb.tsi.duces_edu.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifpb.tsi.duces_edu.model.usuario.RoleUser;
import br.edu.ifpb.tsi.duces_edu.repository.RoleRepository;



public class RoleService implements Service<RoleUser,UUID> {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<RoleUser> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public RoleUser findById(UUID id) {
        return roleRepository.getReferenceById(id);
    }

    @Override
    public RoleUser save(RoleUser t) {
        return roleRepository.save(t);
    }
    
}
