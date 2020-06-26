package worldtestes.relacionamentos;

import model.Pet;
import model.Usuario;
import org.junit.Assert;
import org.junit.Test;
import worldtestes.EntityManagerTest;

import java.util.Arrays;

public class ManyToManyPetUserTest extends EntityManagerTest {

    @Test
    public void verificarManyToManyUsuarioPet(){
        Usuario usuario = entityManager.find(Usuario.class,1);
        Pet pet = entityManager.find(Pet.class,1);




        entityManager.getTransaction().begin();
        usuario.setPetList(Arrays.asList(pet));

        entityManager.getTransaction().commit();
        entityManager.clear();

        Pet petVerificacao = entityManager.find(Pet.class, pet.getPetId());
        Assert.assertFalse(petVerificacao.getUsuarioList().isEmpty());
    }

}
