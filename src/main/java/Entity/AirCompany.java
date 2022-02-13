package Entity;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AirCompany {
    List<Plane> planes;

    public void sortByDistance() {
        Collections.sort(planes, new SortByDistance());
    }

    public List<Plane> findByConsumption(double from, double to) {
        return planes.stream()
                .filter(x -> x.getFuelTankCapacity() > from)
                .filter(x -> x.getFuelConsumptionByOneMile() < to)
                .collect(Collectors.toList());
    }
}
