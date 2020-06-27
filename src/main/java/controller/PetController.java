package controller;

import model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import repository.UsuarioRepository;

import java.util.Optional;

@Controller@RequestMapping("/usuarios")
public class PetController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ModelAndView listar(ModelAndView mv){
        Iterable<Usuario> usuarios = usuarioRepository.findAll();
        mv.addObject("usuarios",usuarios);
        mv.setViewName("usuarios/list");
        return mv;
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar(ModelAndView mv){
        mv.addObject("usuario", new Usuario());
//        mv.addObject("endereco", new Endereco());
        mv.setViewName("usuarios/form");
        return mv;
    }

    @GetMapping("editar/{id}")
    public ModelAndView editar(ModelAndView mv, @PathVariable Long id){
        Usuario usuario = usuarioRepository.findOne(id);

        mv.addObject("usuario",usuario);

        mv.setViewName("usuarios/form_editar");
        return mv;
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(@ModelAttribute Usuario usuario){


        usuarioRepository.save(usuario);
        return new ModelAndView("redirect:/usuarios");
    }
    @GetMapping("excluir/{id}")
    public ModelAndView excluir(ModelAndView mv, @PathVariable Integer id){
        Usuario usuario = new Usuario();
        usuario.setUsuarioId(id);
        usuarioRepository.delete(usuario);

        return new ModelAndView("redirect:/usuarios");
    }
}
