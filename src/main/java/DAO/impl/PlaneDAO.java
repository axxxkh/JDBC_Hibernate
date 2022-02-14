package DAO.impl;

import DAO.IDAOPlane;
import Entity.CargoPlane;
import Entity.PassengerPlane;
import Entity.Plane;
import configuration.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlaneDAO implements IDAOPlane {
    private Connector connector = new Connector();

    //тут ще має бути  CRUD
    @Override
    public List<Plane> getPassengerPlanes() {
        List<Plane> planes = new ArrayList<>();

        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CargoPlanes as p " +
                     "JOIN Planes " + "on p.id=Planes.id;");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String manufacturer = resultSet.getString("Manufacturer");
                String model = resultSet.getString("Model");
                int manufactureYear = resultSet.getInt("ManufacturerString");
                double fuelConsumption = resultSet.getDouble("FuelConsumption");
                double fuelTank = resultSet.getDouble("FuelTank");
                int passengerCapacity = resultSet.getInt("passengerCapacity");
                Plane plane = PassengerPlane.builder()
                        .manufacturer(manufacturer)
                        .model(model)
                        .manufactureYear(manufactureYear)
                        .fuelConsumptionByOneMile(fuelConsumption)
                        .fuelTankCapacity(fuelTank)
                        .passengerCapacity(passengerCapacity)
                        .build();
                planes.add(plane);
                return planes;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Plane> getAll() {
        List<Plane> planes = new ArrayList<>();
        planes = Stream.concat(getAllCargoPlanes().stream(), getPassengerPlanes().stream()).collect(Collectors.toList());
        return planes;
    }

    @Override
    public List<Plane> getAllCargoPlanes() {
        List<Plane> planes = new ArrayList<>();
        try (Connection connection = connector.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM CargoPlanes as p " +
                     "JOIN Planes " + "on p.id=Planes.id;");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String manufacturer = resultSet.getString("Manufacturer");
                String model = resultSet.getString("Model");
                int manufactureYear = resultSet.getInt("ManufactureYear");
                double fuelConsumption = resultSet.getDouble("fuelConsumptionByMile");
                double fuelTank = resultSet.getDouble("fuelTankCapacity");
                double loadCapacity = resultSet.getDouble("loadCapacity");
                Plane plane = CargoPlane.builder()
                        .manufacturer(manufacturer)
                        .model(model)
                        .manufactureYear(manufactureYear)
                        .fuelConsumptionByOneMile(fuelConsumption)
                        .fuelTankCapacity(fuelTank)
                        .loadCapacity(loadCapacity)
                        .build();
                planes.add(plane);
            }
            return planes;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
