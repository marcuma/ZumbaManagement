package com.simplilearn.zumbamanagement.controller;

import com.simplilearn.zumbamanagement.model.Batch;
import com.simplilearn.zumbamanagement.model.Participant;
import com.simplilearn.zumbamanagement.services.BatchService;
import com.simplilearn.zumbamanagement.services.ParticipantService;
import com.simplilearn.zumbamanagement.services.Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "MainController", value="/maincontroller")
public class MainController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action) {
            case "main" -> {
                List<Batch> batches = getBatches();
                req.getSession().setAttribute("batches", batches);

                List<Participant> participants = getParticipants();
                req.getSession().setAttribute("participants", participants);

                req.getRequestDispatcher("/main.jsp").forward(req, resp);
            }
            case "add-participant" -> {
                String session = req.getParameter("session");
                if ( "".equals(session) || session == null) {
                    List<Batch> batchService = getBatches();
                    req.getSession().setAttribute("batchService", batchService);
                    req.getRequestDispatcher("/add-participant.jsp").forward(req, resp);
                } else {
                    Service<Participant> service = new ParticipantService();
                    service.save(req, resp);
                    List<Participant> participants = getParticipants();
                    req.getSession().setAttribute("participants", participants);
                    req.getRequestDispatcher("/main.jsp").forward(req, resp);
                }
            }

            case "add-batch" -> {
                Service<Batch> service = new BatchService();
                service.save(req, resp);
                List<Batch> batches = getBatches();
                req.getSession().setAttribute("batches", batches);
                req.getRequestDispatcher("/main.jsp").forward(req, resp);

                resp.sendRedirect(req.getContextPath() + "/main.jsp");
            }
            case "delete-batch" -> {
                String[] batchIds = req.getParameterValues("batchId");
                List<Batch> batches = new ArrayList<>();
                for (String batchId : batchIds) {
                    Batch batch = new Batch(Integer.parseInt(batchId), null );
                    batches.add(batch);
                }
                Service<Batch> service = new BatchService();
                service.delete(batches);

                batches = getBatches();
                req.getSession().setAttribute("batches", batches);
                req.getRequestDispatcher("/main.jsp").forward(req, resp);
            }
            case "delete-participant" -> {
                String[] participantIds = req.getParameterValues("participantId");
                List<Participant> participants = new ArrayList<>();
                for (String participantId : participantIds) {
                    Participant participant = new Participant(participantId, null, null, null, null);
                    participants.add(participant);
                }
                Service<Participant> service = new ParticipantService();
                service.delete(participants);

                participants = getParticipants();
                req.getSession().setAttribute("participants", participants);
                req.getRequestDispatcher("/main.jsp").forward(req, resp);
            }
            default -> throw new IllegalStateException("Unexpected value: " + action);
        };
    }

    private List<Batch> getBatches() {
        Service<Batch> batchService = new BatchService();
        return batchService.findAll();
    }

    private List<Participant> getParticipants() {
        Service<Participant> participantService = new ParticipantService();
        return participantService.findAll();
    }
}
