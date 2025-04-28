<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Zumba Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .card {
            transition: transform 0.3s;
        }
        .card:hover {
            transform: scale(1.05);
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Zumba Management</a>
    </div>
</nav>
<div class="container my-5" style="display: flex; gap: 40px; justify-content: center;>
    <div class="row g-4">
            <div class="card text-center shadow-sm" style="width: 300px;">
                <div class="card-body">
                    <h5 class="card-title">Add Batch</h5>
                    <p class="card-text">Create a new Zumba batch easily.</p>
                    <a href="add-batch.jsp" class="btn btn-primary">Go</a>
                </div>
            </div>


            <div class="card text-center shadow-sm" style="width: 300px;">
                <div class="card-body">
                    <h5 class="card-title">Add Participant</h5>
                    <p class="card-text">Enroll a participant into a batch.</p>
                    <a href="${pageContext.request.contextPath}/maincontroller?action=add-participant" class="btn btn-primary">Go</a>
                </div>
            </div>

    </div>
</div>

<div style="display: flex; gap: 40px; justify-content: center;">

    <!-- Participants Pane -->
    <div style="border: 1px solid #ccc; border-radius: 10px; padding: 20px; width: 300px;">
        <h3>Participants</h3>
        <form method="post" action="${pageContext.request.contextPath}/maincontroller?action=delete-participant">
            <div style="max-height: 300px; overflow-y: auto;">
                <c:forEach var="participant" items="${participants}">
                    <div>
                        <input type="checkbox" name="participantId" value="${participant.id}" id="participant-${participant.id}">
                        <label for="participant-${participant.id}">${participant.name}</label>
                    </div>
                </c:forEach>
            </div>
            <br>
            <button type="submit" class="btn btn-danger">Delete Selected</button>
        </form>
    </div>

    <!-- Batches Pane -->
    <div style="border: 1px solid #ccc; border-radius: 10px; padding: 20px; width: 300px;">
        <h3>Batches</h3>
        <form method="post" action="${pageContext.request.contextPath}/maincontroller?action=delete-batch">
            <div style="max-height: 300px; overflow-y: auto;">
                <c:forEach var="batch" items="${batches}">
                    <div>
                        <input type="checkbox" name="batchId" value="${batch.id}" id="batch-${batch.id}">
                        <label for="batch-${batch.id}">${batch.session}</label>
                    </div>
                </c:forEach>
            </div>
            <br>
            <button type="submit" class="btn btn-danger">Delete Selected</button>
        </form>
    </div>

</div>
<footer class="bg-light text-center py-3">
    <div class="container">
        <small>&copy; 2025 Zumba Management. All rights reserved.</small>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
