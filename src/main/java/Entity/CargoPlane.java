package Entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class CargoPlane extends Plane {
private double loadCapacity;
}
