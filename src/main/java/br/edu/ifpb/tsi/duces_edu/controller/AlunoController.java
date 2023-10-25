package br.edu.ifpb.tsi.duces_edu.controller;

import java.util.List;
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

import br.edu.ifpb.tsi.duces_edu.model.usuario.Aluno;
import br.edu.ifpb.tsi.duces_edu.services.AlunoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    // Lista todos os usuarios ou pelo tipo definido (adm,aluno,professor)
    @GetMapping()
    public List<Aluno> listAlunos(){
        return alunoService.findAll();
    }

// Busca o usuario pelo ID
    @GetMapping("/{id}")
    public ModelAndView getUsuarioById(@PathVariable(value = "id") UUID id, ModelAndView mv){
        mv.addObject("usuario", alunoService.findById(id));
        mv.setViewName("/usuario/perfil");

        return mv;
    }

    // Chama o formulario do usuario
    @RequestMapping("/novo")
    public ModelAndView getForm(ModelAndView mv, Aluno aluno){
        mv.setViewName("/usuario/formUsuario");
        mv.addObject("usuario", aluno);
        mv.addObject("tipoUsuario", "aluno");
        return mv;
    }

    // Requisição para salvar ou editar o usuario
    @PostMapping()
    public String save(@Valid Aluno aluno, BindingResult result, RedirectAttributes redirectAtt){

        if(result.hasErrors()){
            return "/usuario/formUsuario";
        }

        alunoService.save(aluno);
        redirectAtt.addFlashAttribute("message","Aluno cadastrado com sucesso");

        return "redirect:/usuarios";
    }

}
