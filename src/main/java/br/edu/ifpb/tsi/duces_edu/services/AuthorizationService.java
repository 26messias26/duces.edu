package br.edu.ifpb.tsi.duces_edu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.edu.ifpb.tsi.duces_edu.repository.UsuarioRepository;

public class AuthorizationService implements UserDetailsService{

    @Autowired
    UsuarioRepository ur;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return ur.findByLogin(username);
    }
    
}
