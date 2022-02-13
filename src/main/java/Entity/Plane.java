package Entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Comparator;
@Data
@SuperBuilder
public abstract class Plane implements FlyingDistance {
    private String manufacturer;
    private String model;
    private int manufactureYear;
    private double fuelConsumptionByOneMile;
    private double fuelTankCapacity;

    @Override
    public double getFlyingDistance() {
        return fuelTankCapacity / fuelConsumptionByOneMile;
    }
}
