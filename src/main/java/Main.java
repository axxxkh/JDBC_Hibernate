/*
* https://careers.epam.by/content/dam/epam/by/book_epam_by/JAVA_Methods_Programming_v2.march201 5.pdf task 9
*/

import DAO.IDAOFactory;
import DAO.impl.DAOFactory;
import DAO.impl.PlaneDAO;
import Entity.Impl.AirCompany;

public class Main {
    public static void main(String[] args) {
        IDAOFactory factory = DAOFactory.getInstance();
        PlaneDAO planeDAO = factory.getPlaneDAO();
        AirCompany company = new AirCompany();
        company.setPlanes(planeDAO.getAllCargoPlanes());
        System.out.println(company.toString());
        company.sortByDistance();
        company.getPlanes().stream().forEach(x->System.out.println(x.getFlyingDistance()));
        System.out.println(company.findByConsumption(100, 2000));
        System.out.println(company);
        System.out.println(company.getTotalLoadCapacity());
    }
}
