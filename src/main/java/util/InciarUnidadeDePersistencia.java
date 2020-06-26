package util;

import model.Pet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InciarUnidadeDePersistencia {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Petworld-PU");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Faça seus testes aqui

        Pet pet = entityManager.find(Pet.class, 1);
        System.out.println();
        System.out.println("Este é o nome do pet: " + pet.getPetNome());

        entityManager.close();
        entityManagerFactory.close();

    }
}
