package com.simplilearn.zumbamanagement.services;


import com.simplilearn.zumbamanagement.dao.BatchDaoImpl;
import com.simplilearn.zumbamanagement.dao.Dao;
import com.simplilearn.zumbamanagement.model.Batch;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.sql.Connection;
import java.util.List;

public class BatchService implements Service<Batch> {
    private final Dao<Batch> dao = new BatchDaoImpl();

    @Override
    public Batch findById(long id) {
        return null;
    }

    @Override
    public List<Batch> findAll() {
        List<Batch> batches = dao.getAll();
        return batches;
    }

    @Override
    public void save(HttpServletRequest req, HttpServletResponse resp) {
        String session = req.getParameter("session");
        Batch batch = new Batch(session);
        System.out.println(batch.getSession());
        dao.save(batch);
    }

    @Override
    public Batch update(Batch batch) {
        return null;
    }

    @Override
    public void delete(List<Batch> batches) {
        dao.delete(batches);
    }
}
