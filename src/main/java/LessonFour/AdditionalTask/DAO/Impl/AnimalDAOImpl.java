package LessonFour.AdditionalTask.DAO.Impl;

import LessonFour.AdditionalTask.DAO.AnimalDAO;
import LessonFour.AdditionalTask.Entity.Animal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AnimalDAOImpl implements AnimalDAO {
    private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory entityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence
                    .createEntityManagerFactory("somePUnit");
        }
        return entityManagerFactory;
    }

    @Override
    public Animal add(Animal animal) {
        EntityManager entityManager = entityManagerFactory().createEntityManager();
        entityManager
                .getTransaction()
                .begin();
        if (entityManager.contains(animal)) {
            entityManager.close();
            return null;
        }
        entityManager.merge(animal);
        entityManager
                .getTransaction()
                .commit();
        entityManager.close();
        return animal;
    }

    @Override
    public Animal update(Animal animal) {
        EntityManager entityManager = entityManagerFactory().createEntityManager();
        entityManager
                .getTransaction()
                .begin();
        if (entityManager.contains(animal)) {
            entityManager.merge(animal);
            entityManager
                    .getTransaction()
                    .commit();
            entityManager.close();
            return animal;
        }
        entityManager.close();
        return null;
    }

    @Override
    public boolean delete(Animal animal) {
        EntityManager entityManager = entityManagerFactory().createEntityManager();
        entityManager
                .getTransaction()
                .begin();
        Animal animalFromDb = entityManager.find(Animal.class, animal.getId());
        if (entityManager.contains(animalFromDb)) {
            entityManager.remove(animalFromDb);
            entityManager
                    .getTransaction()
                    .commit();
            entityManager.close();
            return true;
        }
        entityManager.close();
        return false;
    }

    @Override
    public Animal get(int id) {
        EntityManager entityManager = entityManagerFactory().createEntityManager();
        entityManager
                .getTransaction()
                .begin();
        Animal animal = entityManager.find(Animal.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        return animal;
    }
}
