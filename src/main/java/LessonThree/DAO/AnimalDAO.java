package LessonTwo.DAO;

import LessonTwo.Entity.Animal;

public interface AnimalDAO {
    Animal add(Animal animal);
    Animal update (Animal animal);
    boolean delete (Animal animal);
    Animal get ()
}
