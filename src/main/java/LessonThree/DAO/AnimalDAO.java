package LessonThree.DAO;

import LessonThree.Entity.Animal;

public interface AnimalDAO {
    Animal add(Animal animal);
    Animal update (Animal animal);
    boolean delete (Animal animal);
    Animal get (int id);
}
