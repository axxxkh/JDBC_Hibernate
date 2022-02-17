package LessonFour.AdditionalTask;

import LessonFour.AdditionalTask.DAO.AnimalDAO;
import LessonFour.AdditionalTask.DAO.Impl.AnimalDAOImpl;
import LessonFour.AdditionalTask.Entity.Animal;

public class Main {
    public static void main(String[] args) {
        Animal animal = Animal.builder()
                .id(1)
                .name("Jacky")
                .age(10)
                .tail(true)
                .build();
        AnimalDAO animalDAO = new AnimalDAOImpl();
        System.out.println(animalDAO.add(animal));
        System.out.println(animalDAO.get(1));
        System.out.println(animalDAO.delete(animalDAO.get(1)));
    }
}
