package worldtestes.model;

import model.Pet;
import model.Usuario;
import org.junit.Assert;
import org.junit.Test;
import worldtestes.EntityManagerTest;

public class UsuarioCrudTest extends EntityManagerTest {

    @Test
    public void inserirRegistro(){
        Usuario usuario = new Usuario();


      usuario.setUsuarioNome("Balboa");

        entityManager.getTransaction().begin();
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Usuario usuarioVerificacao = entityManager.find(Usuario.class, usuario.getUsuarioId());
        Assert.assertNotNull(usuarioVerificacao);
    }

    @Test
    public void buscarPorIdentificador(){

        Usuario usuario = entityManager.find(Usuario.class,1);
        Assert.assertEquals("Davi", usuario.getUsuarioNome());
    }

    @Test
    public void atualizarRegistro(){
        Usuario usuario = new Usuario();

        usuario.setUsuarioNome("Robert");
        entityManager.getTransaction().begin();
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Usuario usuarioVerificacaoo = entityManager.find(Usuario.class, usuario.getUsuarioId());
        Assert.assertNotNull(usuarioVerificacaoo.getUsuarioId());
        Assert.assertEquals("Robert", usuario.getUsuarioNome());

    }

    @Test
    public void removerRegistro(){
        Usuario usuario = entityManager.find(Usuario.class, 1);
        entityManager.getTransaction().begin();
        entityManager.remove(usuario);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Usuario usuarioVerificacaoo = entityManager.find(Usuario.class, usuario.getUsuarioId());
        Assert.assertNull(usuarioVerificacaoo);

    }




}
