package by.epamtc.task6.factory;

import by.epamtc.task6.model.PassengerPlane;

public class PassengerPlaneFactory extends PlaneFactory<PassengerPlane> {
    private PassengerPlane sample;

    public PassengerPlaneFactory(PassengerPlane sample) {
        this.sample = sample;
    }

    public PassengerPlane getSample() {
        return sample;
    }

    public void setSample(PassengerPlane sample) {
        this.sample = sample;
    }

    @Override
    public PassengerPlane create() {
        return new PassengerPlane(sample);
    }
}