package by.epamtc.task6.model;

import java.io.Serializable;

public class CargoPlane extends Plane implements Serializable {
    private boolean isSupersonic;

    @Override
    double getFuelConsumption() {
        return isSupersonic ? Math.pow(getCargoCapacity(), 2) : getCargoCapacity();
    }

    public CargoPlane(String title, double carryCapacity, int peopleCapacity, boolean isSupersonic) {
        super(title, carryCapacity, peopleCapacity);
        this.isSupersonic = isSupersonic;
    }

    public CargoPlane(CargoPlane other) {
        super(other);
        this.isSupersonic = other.isSupersonic;
    }

    public boolean isSupersonic() {
        return isSupersonic;
    }

    public void setSupersonic(boolean supersonic) {
        isSupersonic = supersonic;
    }

    @Override
    public String toString() {
        return super.toString() + " is superSonic= " + isSupersonic + " fuel consumption= " + getFuelConsumption();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CargoPlane that = (CargoPlane) o;
        return super.equals(that) && isSupersonic == that.isSupersonic && getFuelConsumption() == that.getFuelConsumption();
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        return (int) (hash + 31 * (getFuelConsumption()));
    }

}