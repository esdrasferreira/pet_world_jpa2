package controller;

import model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import repository.Usuarios;
import service.UsuarioService;

import java.util.Map;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    Usuarios usuarios;

    @Autowired
    private UsuarioService service;

    @PostMapping("/{id}/editar")
    public ModelAndView atualizar(@PathVariable Integer id,
                                  @RequestParam Map<String, Object> usuario,
                                  RedirectAttributes redirectAttributes){
        service.atualizar(id, usuario);
        redirectAttributes.addFlashAttribute("mensagem", "Atualização feita com sucesso!");
        return new ModelAndView("redirect:/usuarios{id}/editar");
    }

    @GetMapping("editar/{id}")
    public ModelAndView editar (@PathVariable Integer id){
        Usuario usuario = usuarios.buscar(id);
        ModelAndView mv = new ModelAndView("usuarios/form_editar");
        mv.addObject("usuario", usuario);
        return mv;
    }

    @PostMapping("/salvar")
    public ModelAndView criar(Usuario usuario,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes){
        Usuario atualizado = service.criar(usuario);
        redirectAttributes.addFlashAttribute("mensagem", "Registro criado com sucesso!");
        return new ModelAndView(
                "redirect:/usuarios");
    }

    @GetMapping("/cadastrar")
    public ModelAndView novo(Usuario usuario){
        ModelAndView mv = new ModelAndView("usuarios/form");
        mv.addObject("usuario", usuario);
        return mv;
    }

    @GetMapping
    public ModelAndView listar(){
        ModelAndView mv = new ModelAndView("usuarios/list");
        mv.addObject("usuarios", usuarios.listar());
        return mv;
    }







}
