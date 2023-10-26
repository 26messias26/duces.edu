package br.edu.ifpb.tsi.duces_edu.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import br.edu.ifpb.tsi.duces_edu.model.usuario.Usuario;
import br.edu.ifpb.tsi.duces_edu.repository.UsuarioRepository;

@Component
public class UsuarioService implements Service<Usuario, Integer> {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Integer id) {
        return usuarioRepository.getReferenceById(id);
    }

    @Override
    public Usuario save(Usuario usu) {

        if(usu.getId() == null){
            System.out.println(usu.getId());
            UserDetails ExisteLogin = usuarioRepository.findByLogin(usu.getLogin());
            if (ExisteLogin != null){
                throw new Error("Esse login já esta em uso");
            }
        }
        
        return usuarioRepository.save(usu);

        
    }

    
}
