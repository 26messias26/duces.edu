package br.edu.ifpb.tsi.duces_edu.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ifpb.tsi.duces_edu.model.usuario.Professor;
import br.edu.ifpb.tsi.duces_edu.repository.ProfessorRepository;

@Component
public class ProfessorService implements Service<Professor,UUID> {

    @Autowired
    private ProfessorRepository profRepository;

    @Override
    public List<Professor> findAll() {
        return profRepository.findAll();
    }

    @Override
    public Professor findById(UUID id) {
        return profRepository.getReferenceById(id);
    }

    @Override
    public Professor save(Professor professor) {

        Professor ExisteLogin = profRepository.findByLogin(professor.getLogin());

        if (ExisteLogin != null){
            throw new Error("Esse login já esta em uso");
        }

        // professor.setSenha()
        return profRepository.save(professor);
    }
    
}
