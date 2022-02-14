package DAO;

import DAO.impl.AirCompanyDAO;
import DAO.impl.PlaneDAO;

public interface IDAOFactory {
    PlaneDAO getPlaneDAO();
    AirCompanyDAO getAirCompanyDAO();
}
