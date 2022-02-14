package DAO;

import Entity.Plane;

import java.util.List;

public interface IDAOPlane {
    List<Plane> getAll();
    List<Plane> getAllCargoPlanes();
    List<Plane> getPassengerPlanes();
}
