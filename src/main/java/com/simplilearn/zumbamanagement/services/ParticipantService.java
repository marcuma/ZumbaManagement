package com.simplilearn.zumbamanagement.services;

import com.simplilearn.zumbamanagement.dao.Dao;
import com.simplilearn.zumbamanagement.dao.ParticipantDaoImpl;
import com.simplilearn.zumbamanagement.model.Participant;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public class ParticipantService implements Service<Participant> {
    private final Dao<Participant> dao = new ParticipantDaoImpl();

    @Override
    public List<Participant> findAll() {
        return dao.getAll();
    }

    @Override
    public void save(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        //int id = Integer.parseInt(req.getParameter("id"));
        String sessionId = req.getParameter("session");

        Participant participant = new Participant(null, name, email, phone, sessionId);
        Dao<Participant> dao = new ParticipantDaoImpl();
        dao.save(participant);
    }

    public void delete(List<Participant> participants) {
        dao.delete(participants);
    }
}
