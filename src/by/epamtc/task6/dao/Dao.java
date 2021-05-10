package by.epamtc.task6.dao;

import by.epamtc.task6.exception.NullException;

import java.io.IOException;
import java.util.List;

public interface Dao<T> {
    List<T> getAll() throws IOException;

    void add(T t) throws IOException, NullException;

    void add(List<T> items) throws IOException, NullException;

    void delete(List<T> items) throws IOException, NullException;

    void delete(T t) throws IOException, NullException;

    void clear() throws IOException, NullException;

    boolean isEmpty();
}
