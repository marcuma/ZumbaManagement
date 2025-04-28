<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    // Assume you have a List<Participant> set as a request attribute named "participants"
    //List<Participant> participants = (List<Participant>) request.getAttribute("participants");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Participant</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .card {
            max-width: 700px;
            margin: auto;
            margin-top: 50px;
            transition: transform 0.3s;
        }
        .card:hover {
            transform: scale(1.02);
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Zumba Management</a>
    </div>
</nav>

<div class="container my-5">
    <div class="card shadow-sm">
        <div class="card-body">
            <h3 class="card-title text-center mb-4">Update Participant</h3>
            <form action=${pageContext.request.contextPath}/maincontroller?action=update-participant" method="post">
                <div class="mb-3">
                    <label for="participantSelect" class="form-label">Select Participant</label>
                    <select class="form-select" id="participantSelect" name="participantId" onchange="loadParticipantDetails()" required>
                        <option value="" disabled selected>Select a participant</option>
<%--                        <% for (Participant p : participants) { %>--%>
<%--                        <option value="<%= p.getId() %>"--%>
<%--                                data-name="<%= p.getName() %>"--%>
<%--                                data-email="<%= p.getEmail() %>"--%>
<%--                                data-phone="<%= p.getPhone() %>"--%>
<%--                                data-batch="<%= p.getBatch() %>">--%>
<%--                            <%= p.getName() %>--%>
<%--                        </option>--%>
<%--                        <% } %>--%>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="name" class="form-label">Name</label>
                    <input type="text" class="form-control" id="name" name="name" required>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">Email</label>
                    <input type="email" class="form-control" id="email" name="email" required>
                </div>
                <div class="mb-3">
                    <label for="phone" class="form-label">Phone</label>
                    <input type="tel" class="form-control" id="phone" name="phone" required>
                </div>
                <div class="mb-3">
                    <label for="batch" class="form-label">Batch</label>
                    <input type="text" class="form-control" id="batch" name="batch" required>
                </div>

                <div class="d-grid">
                    <button type="submit" class="btn btn-primary">Update Participant</button>
                </div>
            </form>
        </div>
    </div>
</div>

<footer class="bg-light text-center py-3 mt-5">
    <div class="container">
        <small>&copy; 2025 Zumba Management. All rights reserved.</small>
    </div>
</footer>

<script>
    function loadParticipantDetails() {
        var select = document.getElementById('participantSelect');
        var selectedOption = select.options[select.selectedIndex];

        document.getElementById('name').value = selectedOption.getAttribute('data-name') || '';
        document.getElementById('email').value = selectedOption.getAttribute('data-email') || '';
        document.getElementById('phone').value = selectedOption.getAttribute('data-phone') || '';
        document.getElementById('batch').value = selectedOption.getAttribute('data-batch') || '';
    }
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

