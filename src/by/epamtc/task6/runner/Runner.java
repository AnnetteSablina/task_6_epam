package by.epamtc.task6.runner;

import by.epamtc.task6.comparator.PlaneComparator;
import by.epamtc.task6.dao.Dao;
import by.epamtc.task6.dao.SerializableDao;
import by.epamtc.task6.exception.NullException;
import by.epamtc.task6.factory.CargoPlaneFactory;
import by.epamtc.task6.factory.PassengerPlaneFactory;
import by.epamtc.task6.factory.PlaneFactory;
import by.epamtc.task6.model.Airline;
import by.epamtc.task6.model.CargoPlane;
import by.epamtc.task6.model.PassengerPlane;
import by.epamtc.task6.model.Plane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        Dao<Plane> dao = new SerializableDao<>("./src/by/epamtc/task6/resources/db.txt", Plane.class);
        if (dao.isEmpty()) {
            PlaneFactory<?> factory = new CargoPlaneFactory(new CargoPlane("Boeing 757-200F", 1000000, 4, true));
            var planes = new ArrayList<Plane>(factory.getNext(5));
            factory = new PassengerPlaneFactory(new PassengerPlane("Boeing 747", 1000, 366, 4,16));
            planes.addAll(factory.getNext(10));
            try {
                dao.add(planes);
            } catch (IOException | NullException e) {
                System.err.println("Could not save planes");
                e.printStackTrace();
            }
        }
        List<Plane> planes;
        try {
            planes = dao.getAll();
            System.out.println("Loaded planes: \n" + planes);
        } catch (IOException e) {
            System.err.println("Could not get planes");
            e.printStackTrace();
            return;
        }

        Airline airline = null;
        try {
            airline = new Airline(planes);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        if (airline != null) {
            airline.sort(new PlaneComparator());
        }
        System.out.println(airline);

        System.out.printf("Total: %f passengers %n", airline.getTotalPassengerCapacity());
        System.out.printf("Total: %f cargo capacity %n", airline.getTotalCargoCapacity());

        //filter planes with given criteria
        var list = airline.getPlanesMatching(
                (Plane p) -> p.getPassengerCapacity() > 2 && p.getPassengerCapacity() < 100);
        System.out.printf("Planes matching criteria: %d %n", list.size());
    }
}

