package by.epamtc.task6.model;

import java.io.Serializable;

public class PassengerPlane extends Plane implements Serializable {
    private int engineCount;

    @Override
    double getFuelConsumption() {
        return getPassengerCapacity() * getEngineCount();
    }

    public PassengerPlane(String title, double carryCapacity, int peopleCapacity, int engineCount) {
        super(title, carryCapacity, peopleCapacity);
        this.engineCount = engineCount;
    }

    public PassengerPlane(PassengerPlane other) {
        super(other);
        this.engineCount = other.engineCount;
    }

    public int getEngineCount() {
        return engineCount;
    }

    public void setEngineCount(int engineCount) {
        this.engineCount = engineCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassengerPlane that = (PassengerPlane) o;
        return super.equals(that) && engineCount == that.engineCount && getFuelConsumption() == that.getFuelConsumption();
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        return hash = (int) (31 * (engineCount + getFuelConsumption()));
    }

    @Override
    public String toString() {
        return super.toString() + " engine count= " + engineCount + " fuel consumption= " + getFuelConsumption();
    }

}
