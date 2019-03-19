package dao;

import java.util.Collection;

public interface Dao<T> {
public T find(int unId);
public boolean create(T obj);
public Collection<T> findAll();
public boolean update(T obj);
public boolean delete(T obj);
public boolean deleteAll();
public void close();

}
