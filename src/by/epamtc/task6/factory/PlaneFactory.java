package by.epamtc.task6.factory;

import by.epamtc.task6.model.Plane;

import java.util.ArrayList;
import java.util.List;

public abstract class PlaneFactory<T extends Plane> implements Factory<Plane> {
    static private int counter = 0;

    public abstract T create();

    public static void setCounter(int counter) {
        PlaneFactory.counter = counter;
    }

    public static int getCounter() {
        return counter;
    }

    public T getNext() {
        T obj = create();
        obj.setTitle("%s #%d".formatted(obj.getTitle(), ++counter));
        return obj;
    }

    public List<T> getNext(int amount) {
        List<T> ret = new ArrayList<>();
        for (int i = 0; i != amount; ++i) {
            ret.add(getNext());
        }
        return ret;
    }
}
