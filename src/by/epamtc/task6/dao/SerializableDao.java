package by.epamtc.task6.dao;

import by.epamtc.task6.exception.ClassNotFoundException;
import by.epamtc.task6.exception.NullException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SerializableDao<T> implements Dao<T> {
    private final String filename;
    private final Class<T> clazz;

    @Override
    public List<T> getAll() throws IOException {
        var ret = new ArrayList<T>();
        if (isEmpty()) return ret;
        try (var stream = openInStream()) {
            int objCount = stream.readInt();
            for (int i = 0; i < objCount; ++i) {
                T p = clazz.cast(stream.readObject());
                ret.add(p);
            }
        } catch (java.lang.ClassNotFoundException e) {
            throw new ClassNotFoundException(e);
        }
        return ret;
    }

    @Override
    public void add(T obj) throws IOException, NullException {
        List<T> old = getAll();
        old.add(obj);
        saveAll(old);
    }

    @Override
    public void add(List<T> items) throws IOException, NullException {
        List<T> old = getAll();
        old.addAll(items);
        saveAll(items);
    }

    @Override
    public void delete(List<T> items) throws IOException, NullException {
        List<T> old = getAll();
        old.removeAll(items);
        saveAll(items);
    }

    @Override
    public void delete(T obj) throws IOException, NullException {
        List<T> old = getAll();
        old.remove(obj);
        saveAll(old);
    }

    @Override
    public void clear() throws IOException, NullException {
        saveAll(new ArrayList<>()); //save empty list
    }

    @Override
    public boolean isEmpty() {
        try (var stream = openInStream()) {
            return stream.readInt() == 0;
        } catch (IOException e) {
            return true;
        }
    }

    public SerializableDao(String filename, Class<T> clazz) {
        this.filename = filename;
        this.clazz = clazz;
    }

    public String getFilename() {
        return filename;
    }

    private ObjectInputStream openInStream() throws IOException {
        var path = Paths.get(filename);
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        FileInputStream in = new FileInputStream(filename);
        return new ObjectInputStream(in);
    }

    private ObjectOutputStream openOutStream() throws IOException {
        FileOutputStream f = new FileOutputStream(filename);
        return new ObjectOutputStream(f);
    }

    private void saveAll(List<T> items) throws IOException, NullException {
        if (items == null) throw new NullException("Items is null");
        try (var stream = openOutStream()) {
            //save the object count
            stream.writeInt(items.size());
            for (var obj : items) {
                if (obj == null) throw new NullException("Item is null");
                    stream.writeObject(obj);
            }
        }
    }
}
