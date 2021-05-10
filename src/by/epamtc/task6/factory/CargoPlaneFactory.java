package by.epamtc.task6.factory;

import by.epamtc.task6.model.CargoPlane;

public class CargoPlaneFactory extends PlaneFactory<CargoPlane> {
    private CargoPlane sample;

    public CargoPlaneFactory(CargoPlane sample) {
        this.sample = sample;
    }

    public CargoPlane getSample() {
        return sample;
    }

    public void setSample(CargoPlane sample) {
        this.sample = sample;
    }

    @Override
    public CargoPlane create() {
        return new CargoPlane(sample);
    }
}