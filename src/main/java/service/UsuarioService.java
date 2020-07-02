package service;

import model.Usuario;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.Usuarios;

import javax.transaction.Transactional;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@Service
public class UsuarioService {

    @Autowired
    private Usuarios usuarios;

    @Transactional
    public Usuario criar(Usuario usuario){
        return usuarios.salvar(usuario);
    }

    @Transactional
    public Usuario atualizar(Integer id, Map<String, Object> usuario){
        Usuario usuarioAtual = usuarios.buscar(id);

        try{
            BeanUtils.populate(usuarioAtual, usuario);

        }catch (IllegalAccessException | InvocationTargetException e){
            throw new RuntimeException(e);
        }
        return usuarios.salvar(usuarioAtual);
    }
}
