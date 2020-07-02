package repository;


import model.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class Usuarios{

    @PersistenceContext
    private EntityManager entityManager;

    public Usuario buscar(Integer id){
        return entityManager.find(Usuario.class, id);
    }

    public Usuario salvar(Usuario usuario){
        return entityManager.merge(usuario);
    }

    public List<Usuario> listar(){
        return entityManager
                .createQuery("select u from Usuario u", Usuario.class)
                .getResultList();
    }
}
