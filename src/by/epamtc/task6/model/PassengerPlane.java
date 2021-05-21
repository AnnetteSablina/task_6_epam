package by.epamtc.task6.model;

import java.io.Serializable;

public class PassengerPlane extends Plane implements Serializable, Cloneable {
    private int engineCount;
    private int vipPassengerSeatsCount;
    private int passengerSeatsCount;
    private int flightAttendantsCount;
    private int toiletsCount;


    public int getToiletsCount() {
        return toiletsCount;
    }

    public void setToiletsCount(int toiletsCount) {
        this.toiletsCount = toiletsCount;
    }

    public int getFlightAttendantsCount() {
        return flightAttendantsCount;
    }

    public void setFlightAttendantsCount(int flightAttendantsCount) {
        this.flightAttendantsCount = flightAttendantsCount;
    }

    public int getVipPassengerSeatsCount() {
        return vipPassengerSeatsCount;
    }

    public void setVipPassengerSeatsCount(int vipPassengerSeatsCount) {
        this.vipPassengerSeatsCount = vipPassengerSeatsCount;
    }

    public int getPassengerSeatsCount() {
        return passengerSeatsCount;
    }

    public void setPassengerSeatsCount(int passengerSeatsCount) {
        this.passengerSeatsCount = passengerSeatsCount;
    }

    public PassengerPlane(PassengerPlane other) {
        super(other);
        this.engineCount = other.engineCount;
        this.vipPassengerSeatsCount = other.vipPassengerSeatsCount;
        this.passengerSeatsCount = other.passengerSeatsCount;
        this.flightAttendantsCount = other.flightAttendantsCount;
        this.toiletsCount = other.toiletsCount;
    }


    public PassengerPlane(String title, double cargoCapacity, int passengerCapacity, int engineCount,
                          int vipPassengerSeatsCount, int passengerSeatsCount, int flightAttendantsCount,
                          int toiletsCount) {
        super(title, cargoCapacity, passengerCapacity);
        this.engineCount = engineCount;
        this.vipPassengerSeatsCount = vipPassengerSeatsCount;
        this.passengerSeatsCount = passengerSeatsCount;
        this.flightAttendantsCount = flightAttendantsCount;
        this.toiletsCount = toiletsCount;
    }

    public int getEngineCount() {
        return engineCount;
    }

    public void setEngineCount(int engineCount) {
        this.engineCount = engineCount;
    }


   /* @Override
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
    }*/

   /* @Override
    public String toString() {
        return super.toString() + " engine count= " + engineCount + " fuel consumption= " + getFuelConsumption();
    }*/

    @Override
    public PassengerPlane clone() throws CloneNotSupportedException {
        return (PassengerPlane) super.clone();
    }

    @Override
    double getFuelConsumption() {
        return getPassengerCapacity() * getEngineCount();
    }

}
