package br.edu.ifpb.tsi.duces_edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    // Lista todos os usuarios ou pelo tipo definido (adm,usuario,professor)
    @GetMapping()
    public String listUsuarios(){
        return "/usuarios";
    }

    // Busca o usuario pelo ID
    @GetMapping("/{id}")
    public void getUsuarioById(){

    }
    
    // Chama o formulario do usuario
    @RequestMapping("/form/")
    public String getForm(){

        return "usuario/formUsuario";
    }

    // Requisição para salvar ou editar o usuario
    @PostMapping()
    public void saveUsuario(){
        
    }

}
