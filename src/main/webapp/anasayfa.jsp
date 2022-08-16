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
                <th>patient_id</th>
                <th>first_name</th>
                <th>last_name</th>
                <th>tc_no</th>
                <th>date_of_birth</th>
                <th>tel_no</th>
                <th>job</th>
                <th>gender</th>
                <th>report_date</th>
                <th>address</th>

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
                    <td><c:out value="${Patient.tc_no}" /></td>
                    <td><c:out value="${Patient.tc_no}" /></td>
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