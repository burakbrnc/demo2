<<<<<<< Updated upstream
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>patient</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: tomato">
        <div>
            <a href="http://localhost:8080/demo2_war_exploded/" class="navbar-brand"> Log Out </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
                   class="nav-link">Patient</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">
    <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

    <div class="container">
        <h3 class="text-center">List of Patients</h3>
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
                New Patient</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Id</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Tc No</th>
                <th>Date Of Birth</th>
                <th>Tel No</th>
                <th>Job</th>
                <th>Gender</th>
                <th>Report Date</th>
                <th>Address</th>

            </tr>
            </thead>
            <tbody>
            <!--   for (Todo todo: todos) {  -->
            <c:forEach var="Patient" items="${listPatient}">

                <tr>
                    <td><c:out value="${Patient.patient_id}" /></td>
                    <td><c:out value="${Patient.first_name}" /></td>
                    <td><c:out value="${Patient.last_name}" /></td>
                    <td><c:out value="${Patient.tc_no}" /></td>
                    <td><c:out value="${Patient.date_of_birth}" /></td>
                    <td><c:out value="${Patient.tel_no}" /></td>
                    <td><c:out value="${Patient.job}" /></td>
                    <td><c:out value="${Patient.gender}" /></td>
                    <td><c:out value="${Patient.report_date}" /></td>
                    <td><c:out value="${Patient.address}" /></td>

                    <td><a href="edit?id=<c:out value='${Patient.patient_id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp; <a
                                href="delete?id=<c:out value='${Patient.patient_id}' />">Delete</a></td>
                </tr>
            </c:forEach>
            <!-- } -->
            </tbody>

        </table>
    </div>
</div>
</body>

</html>
=======
>>>>>>> Stashed changes
