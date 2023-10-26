package br.edu.ifpb.tsi.duces_edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.tsi.duces_edu.model.usuario.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {

    UserDetails findByLogin(String login);

}
