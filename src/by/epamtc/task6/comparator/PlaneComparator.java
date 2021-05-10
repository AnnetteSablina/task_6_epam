package by.epamtc.task6.comparator;

import by.epamtc.task6.model.Plane;

import java.util.Comparator;

public class PlaneComparator implements Comparator<Plane> {

    @Override
    public int compare(Plane o1, Plane o2) {
        return Double.compare(o1.getPassengerCapacity(), o2.getPassengerCapacity());
    }

    @Override
    public Comparator<Plane> thenComparing(Comparator<? super Plane> other) {
         return Comparator.comparing(Plane::getTitle);
    }
}
