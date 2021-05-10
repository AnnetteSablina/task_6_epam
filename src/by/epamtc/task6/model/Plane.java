package by.epamtc.task6.model;

import java.io.Serializable;

public abstract class Plane implements Serializable {
    private String title;
    private double cargoCapacity; //e.g. tons
    private int passengerCapacity;

    public Plane(Plane other) {
        this.title = other.title;
        this.cargoCapacity = other.cargoCapacity;
        this.passengerCapacity = other.passengerCapacity;
    }

    abstract double getFuelConsumption();

    public Plane(String title, double cargoCapacity, int passengerCapacity) {
        this.title = title;
        this.cargoCapacity = cargoCapacity;
        this.passengerCapacity = passengerCapacity;
    }

    public double getCargoCapacity() {
        return cargoCapacity;
    }

    public void setCargoCapacity(double cargoCapacity) {
        this.cargoCapacity = cargoCapacity;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "title='" + title + '\'' +
                ", carryCapacity=" + cargoCapacity +
                ", peopleCapacity=" + passengerCapacity +
                ", fuelConsumption=" + getFuelConsumption() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return Double.compare(plane.cargoCapacity, cargoCapacity) == 0 &&
                passengerCapacity == plane.passengerCapacity && title.equals(plane.title);
    }

    @Override
    public int hashCode() {
        int hash = 1;
        return 31 * ((int) cargoCapacity + (title == null ? 0 : title.hashCode()) + passengerCapacity);
    }
}