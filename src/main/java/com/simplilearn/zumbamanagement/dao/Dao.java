package com.simplilearn.zumbamanagement.dao;

import java.util.List;

public interface Dao<T> {
    public T getById(int id);
    public List<T> getAll();
    public void save(T t);
    public void update(T t);
    public void delete(T t);
}
