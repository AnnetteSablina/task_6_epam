package by.epamtc.task6.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class Airline {
    private ArrayList<Plane> planes;

    public double getTotalPassengerCapacity() {
        double sum = 0.0;
        for (var plane : planes) {
            sum += plane.getPassengerCapacity();
        }
        return sum;
    }

    public double getTotalCargoCapacity() {
        double sum = 0.0;
        for (var plane : planes) {
            sum += plane.getCargoCapacity();
        }
        return sum;
    }

    public void sort(Comparator<Plane> comp) {
        planes.sort(comp);
    }

    public ArrayList<Plane> getPlanesMatching(Predicate<Plane> criterion) {
        ArrayList<Plane> ret = new ArrayList<>();
        for (var plane : planes) {
            if (criterion.test(plane))
                ret.add(plane);
        }
        return ret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return planes.equals(airline.planes);
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        for (var plane : planes)
            hashCode = 31 * hashCode + (plane == null ? 0 : plane.hashCode());
        return hashCode;
    }

    @Override
    public String toString() {
        return "Airline{" +
                "planes=" + planes +
                '}';
    }
}
