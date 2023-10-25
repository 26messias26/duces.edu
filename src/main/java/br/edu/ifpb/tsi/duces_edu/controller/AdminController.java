package br.edu.ifpb.tsi.duces_edu.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.ifpb.tsi.duces_edu.model.usuario.Admin;
import br.edu.ifpb.tsi.duces_edu.services.AdminService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;
    
    @RequestMapping("/novo")
    public ModelAndView getForm(ModelAndView mv, Admin admin){
        mv.setViewName("usuario/formUsuario");
        mv.addObject("usuario", admin);
        mv.addObject("tipoUsuario", "admin");

        return mv;
    }

    // Busca o usuario pelo ID (perfil)
    @GetMapping("/{id}")
    public ModelAndView getUsuarioById(@PathVariable(value = "id") UUID id, ModelAndView mv){
        mv.addObject("usuario", adminService.findById(id));
        mv.setViewName("/usuario/perfil");

    return mv;

    }
    
    // Requisição para salvar ou editar o usuario
    @PostMapping()
    public String save(@Valid Admin admin, BindingResult result, RedirectAttributes redirectAtt){

        if(result.hasErrors()){
            return "usuario/formUsuario";
        }

        adminService.save(admin);
        redirectAtt.addFlashAttribute("message","Admin cadastrado com sucesso");

        return "redirect:/usuarios";
    }
    
}
