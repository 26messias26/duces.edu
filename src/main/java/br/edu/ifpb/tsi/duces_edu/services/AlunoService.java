package br.edu.ifpb.tsi.duces_edu.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ifpb.tsi.duces_edu.model.usuario.Aluno;
import br.edu.ifpb.tsi.duces_edu.repository.AlunoRepository;

@Component
public class AlunoService implements Service<Aluno,UUID>{

    @Autowired
    AlunoRepository alunoRepository;

    @Override
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno findById(UUID id) {
        return alunoRepository.getReferenceById(id);
    }

    @Override
    public Aluno save(Aluno aluno) {

        Aluno ExisteLogin = alunoRepository.findByLogin(aluno.getLogin());

        if (ExisteLogin != null){
            throw new Error("Esse login já esta em uso");
        }

        // aluno.setSenha()
        return alunoRepository.save(aluno);
    }
    
}
