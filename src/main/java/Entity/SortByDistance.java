package Entity;

import java.util.Comparator;

public class SortByDistance implements Comparator<Plane> {
    @Override
    public int compare(Plane planeOne, Plane planeTwo) {
        if (planeOne.getFlyingDistance() > planeTwo.getFlyingDistance()) {
            return 1;
        } else if (planeOne.getFlyingDistance() < planeTwo.getFlyingDistance()) {
            return -1;
        }
        return 0;
    }
}
