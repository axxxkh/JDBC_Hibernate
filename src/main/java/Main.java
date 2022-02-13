/*
* https://careers.epam.by/content/dam/epam/by/book_epam_by/JAVA_Methods_Programming_v2.march201 5.pdf task 9
*/

import DAO.IDAOFactory;
import DAO.impl.DAOFactory;
import DAO.impl.PlaneDAO;

public class Main {
    public static void main(String[] args) {
        IDAOFactory factory = DAOFactory.getInstance();
        PlaneDAO planeDAO = factory.getPlaneDAO();
        planeDAO.getAllCargoPlanes().stream().forEach(System.out::println);

    }
}
