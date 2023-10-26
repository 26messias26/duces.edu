package br.edu.ifpb.tsi.duces_edu.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ifpb.tsi.duces_edu.model.usuario.RoleUser;
import br.edu.ifpb.tsi.duces_edu.repository.RoleRepository;


@Component
public class RoleService implements Service<RoleUser,Integer> {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<RoleUser> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public RoleUser findById(Integer id) {
        return roleRepository.getReferenceById(id);
    }

    @Override
    public RoleUser save(RoleUser t) {
        return roleRepository.save(t);
    }
    
}
