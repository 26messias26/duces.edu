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

import br.edu.ifpb.tsi.duces_edu.model.usuario.Professor;
import br.edu.ifpb.tsi.duces_edu.services.ProfessorService;
import br.edu.ifpb.tsi.duces_edu.services.RoleService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    ProfessorService profService;
    @Autowired
    RoleService rs;
    // Requisição para salvar ou editar o usuario
    @RequestMapping("/novo")
    public ModelAndView getForm(ModelAndView mv, Professor professor){
        mv.setViewName("/usuario/formUsuario");
        mv.addObject("usuario", professor);
        mv.addObject("tipoUsuario", "professor");
        mv.addObject("roles", rs.findAll());

        return mv;
    }
    
    // Busca o usuario pelo ID (perfil)
    @GetMapping("/{id}")
    public ModelAndView getUsuarioById(@PathVariable(value = "id") UUID id, ModelAndView mv){
        mv.addObject("usuario", profService.findById(id));
        mv.setViewName("/usuario/perfil");

        return mv;
    }

    @PostMapping()
    public String save(@Valid Professor prof, BindingResult result, RedirectAttributes redirectAtt){

        if(result.hasErrors()){
            return "/usuario/formUsuario";
        }

        profService.save(prof);
        System.out.println(prof);
        redirectAtt.addFlashAttribute("message","Professor cadastrado com sucesso");

        return "redirect:/usuarios";
    }

}
