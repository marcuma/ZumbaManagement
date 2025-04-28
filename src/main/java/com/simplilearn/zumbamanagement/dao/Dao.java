package com.simplilearn.zumbamanagement.dao;

import com.simplilearn.zumbamanagement.DB.DBConnection;
import com.simplilearn.zumbamanagement.model.Batch;

import java.util.List;

public interface Dao<T> {
    public List<T> getAll();
    public  int save(T t);
    public void delete(List<T> t);
}
