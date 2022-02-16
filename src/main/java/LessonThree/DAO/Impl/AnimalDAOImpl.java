package LessonThree.DAO.Impl;

import LessonThree.DAO.AnimalDAO;
import LessonThree.Entity.Animal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AnimalDAOImpl implements AnimalDAO {
    private static SessionFactory sessionFactory;

    private static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = new Configuration()
                    .configure()
                    .buildSessionFactory();
        }
        return sessionFactory;
    }

    @Override
    public Animal add(Animal animal) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(animal);
        transaction.commit();
        session.close();
        return animal;
    }

    @Override
    public Animal update(Animal animal) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(animal);
        transaction.commit();
        session.close();
        return animal;
    }

    @Override
    public boolean delete(Animal animal) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Animal persistence = session.load(Animal.class, animal.getId());
        if (persistence != null) {
            session.delete(persistence);
            transaction.commit();
            session.close();
            return true;
        }
        return false;
    }

    @Override
    public Animal get(int id) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Animal animal = session.get(Animal.class, id);
        transaction.commit();
        session.close();
        return animal;
    }
}
