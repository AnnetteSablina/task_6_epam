package by.epamtc.task6.model;

import java.io.Serializable;

public class CargoPlane extends Plane implements Serializable,Cloneable {
    private boolean isSupersonic;
    private int value;//объем внутри самолета
    private boolean isAnimalTransported;//может ли перевозить животных

    public boolean isAnimalTransported() {
        return isAnimalTransported;
    }

    public void setAnimalTransported(boolean animalTransported) {
        isAnimalTransported = animalTransported;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

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
        this.value = other.value;
        this.isAnimalTransported = other.isAnimalTransported;
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

    public CargoPlane(String title, double cargoCapacity, int passengerCapacity, boolean isSupersonic
            , int value, boolean isAnimalTransported) {
        super(title, cargoCapacity, passengerCapacity);
        this.isSupersonic = isSupersonic;
        this.value = value;
        this.isAnimalTransported = isAnimalTransported;
    }

    @Override
    public int hashCode() {
        int hash = super.hashCode();
        return (int) (hash + 31 * (getFuelConsumption() + value));
    }

    @Override
    public CargoPlane clone() throws CloneNotSupportedException {
        return (CargoPlane) super.clone();
    }

}