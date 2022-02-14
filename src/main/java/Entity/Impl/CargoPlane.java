package Entity.Impl;

import Entity.Plane;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@ToString(callSuper = true)
@SuperBuilder
public class CargoPlane extends Plane {
private double loadCapacity;
}
