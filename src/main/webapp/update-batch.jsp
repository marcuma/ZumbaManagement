<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Batch</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .card {
            max-width: 600px;
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
            <h3 class="card-title text-center mb-4">Update Batch</h3>
            <form action="${pageContext.request.contextPath}/maincontroller?action=update-batch" method="post">
                <div class="mb-3">
                    <label for="sessionSelect" class="form-label">Select Session</label>
                    <select class="form-select" id="sessionSelect" name="session" onchange="fillBatchName()" required>
                        <option value="" disabled selected>Select a session</option>
                        <option value="Morning">Morning</option>
                        <option value="Evening">Evening</option>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="batchName" class="form-label">Batch Name</label>
                    <input type="text" class="form-control" id="batchName" name="batchName" required>
                </div>

                <div class="d-grid">
                    <button type="submit" class="btn btn-primary">Update Batch</button>
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
    function fillBatchName() {
        var session = document.getElementById('sessionSelect').value;
        if (session === "Morning") {
            document.getElementById('batchName').value = "Morning Batch";
        } else if (session === "Evening") {
            document.getElementById('batchName').value = "Evening Batch";
        } else {
            document.getElementById('batchName').value = '';
        }
    }
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
