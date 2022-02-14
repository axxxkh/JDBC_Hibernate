package Entity;

import lombok.Data;

import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Data
public class AirCompany {
    List<Plane> planes;
    // в теорії теж має CRUD  бути але фактично в мене в базі одна компанія. не було часу
    // створювати ще таблицю компаній, референтів з літаками і тд
    public void sortByDistance() {
        Collections.sort(this.planes, new SortByDistance());
    }

    public List<Plane> findByConsumption(double from, double to) {
        return planes.stream()
                .filter(x -> x.getFuelTankCapacity() > from)
                .filter(x -> x.getFuelConsumptionByOneMile() < to)
                .collect(toList());
    }

    public double getTotalLoadCapacity() {
        List<CargoPlane> cargoPlanes = planes.stream()
                .filter(x -> x.getClass().equals(CargoPlane.class))
                .map(x->(CargoPlane) x)
                .collect(toList());
        return cargoPlanes.stream().map(x -> x.getLoadCapacity()).reduce((a, b) -> a + b).orElse(0.0);
    }

    public int getTotalPassengerCapacity() {
        List<PassengerPlane> cargoPlanes = planes.stream()
                .filter(x -> x.getClass().equals(PassengerPlane.class))
                .map(x->(PassengerPlane) x)
                .collect(toList());
        return cargoPlanes.stream().map(x -> x.getPassengerCapacity()).reduce((a, b) -> a + b).orElse(0);
    }
}
