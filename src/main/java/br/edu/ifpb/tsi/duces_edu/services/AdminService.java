package br.edu.ifpb.tsi.duces_edu.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ifpb.tsi.duces_edu.model.usuario.Admin;
import br.edu.ifpb.tsi.duces_edu.repository.AdminRepository;

@Component
public class AdminService implements Service<Admin,UUID> {

    @Autowired
    AdminRepository adminRepository;

    @Override
    public List<Admin> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Admin findById(UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Admin save(Admin admin) {

        Admin ExisteLogin = adminRepository.findByLogin(admin.getLogin());

        if (ExisteLogin != null){
            throw new Error("Esse login já esta em uso");
        }

        // admin.setSenha()
        return adminRepository.save(admin);
    }
    
}
