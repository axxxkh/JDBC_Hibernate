package Entity;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class PassengerPlane extends Plane {
private int passengerCapacity;
}
