package com.simplilearn.zumbamanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

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
        String command = req.getParameter("command");

        String page = switch (command) {
            case "home" -> "index.jsp";
            case "add-participant" -> "add-participant.jsp";
            case "add-batch" -> "add-batch.jsp";
            case "update-batch" -> "update-batch.jsp";
            case "update-participant" -> "update-participant.jsp";
            default -> throw new IllegalStateException("Unexpected value: " + command);
        };

        req.getRequestDispatcher(page).forward(req, resp);
    }
}
