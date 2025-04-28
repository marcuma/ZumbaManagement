package com.simplilearn.zumbamanagement.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public interface Service<T> {
    public T findById(long id);
    public List<T> findAll();
    public void save(HttpServletRequest req, HttpServletResponse resp);
    public T update(T t);
    public void delete(List<T> t);
}
