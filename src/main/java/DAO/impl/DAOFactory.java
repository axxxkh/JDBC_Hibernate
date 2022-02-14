package DAO.impl;

import DAO.IDAOFactory;

public class DAOFactory implements IDAOFactory {

    private static DAOFactory factory;

    private DAOFactory() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver is loaded!");
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    public static synchronized DAOFactory getInstance() {
        if (factory == null) {
            factory = new DAOFactory();
        }
        return factory;
    }

    @Override
    public PlaneDAO getPlaneDAO() {
        return new PlaneDAO();
    }

    @Override
    public AirCompanyDAO getAirCompanyDAO() {
        return new AirCompanyDAO();
    }
}
