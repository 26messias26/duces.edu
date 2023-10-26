package br.edu.ifpb.tsi.duces_edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifpb.tsi.duces_edu.services.UsuarioService;

@Controller
@RequestMapping(value = "/")
public class HomeController {
    
    @GetMapping()
    public String home(){
        return "/usuario/perfil";
    }

    

}
