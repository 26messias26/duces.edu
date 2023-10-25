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

    
    
}
