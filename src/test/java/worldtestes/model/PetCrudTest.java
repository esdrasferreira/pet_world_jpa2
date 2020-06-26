package worldtestes.model;

import model.Pet;
import org.junit.Assert;
import org.junit.Test;
import worldtestes.EntityManagerTest;

public class PetCrudTest extends EntityManagerTest {

    @Test
    public void inserirRegistro(){
        Pet pet = new Pet();


      pet.setPetNome("Lion");

        entityManager.getTransaction().begin();
        entityManager.persist(pet);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Pet petVerificacao = entityManager.find(Pet.class, pet.getPetId());
        Assert.assertNotNull(petVerificacao);
    }

    @Test
    public void buscarPorIdentificador(){

        Pet pet = entityManager.find(Pet.class,1);
        Assert.assertEquals("Guga", pet.getPetNome());
    }

    @Test
    public void atualizarRegistro(){
        Pet pet = new Pet();

        pet.setPetNome("Andy");
        entityManager.getTransaction().begin();
        entityManager.persist(pet);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Pet petVerificacao = entityManager.find(Pet.class,pet.getPetId());
        Assert.assertNotNull(petVerificacao.getPetId());
        Assert.assertEquals("Andy", pet.getPetNome());

    }

    @Test
    public void removerRegistro(){
        Pet pet = entityManager.find(Pet.class, 1);
        entityManager.getTransaction().begin();
        entityManager.remove(pet);
        entityManager.getTransaction().commit();
        entityManager.clear();

        Pet petVerificacao = entityManager.find(Pet.class, pet.getPetId());
        Assert.assertNull(petVerificacao);

    }




}
