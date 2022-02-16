package LessonThree;

import LessonThree.DAO.AnimalDAO;
import LessonThree.DAO.Impl.AnimalDAOImpl;
import LessonThree.Entity.Animal;

public class Main {
    private static AnimalDAO animalDAO = new AnimalDAOImpl();

    public static void main(String[] args) {
        Animal doggy = Animal.builder()
                .name("Boss")
                .age(8)
                .build();
//        animalDAO.add(doggy);
//        doggy.setAge(10);
//        animalDAO.update(doggy);
        animalDAO.delete(doggy);
        System.out.println(animalDAO.get(2));
    }
}
