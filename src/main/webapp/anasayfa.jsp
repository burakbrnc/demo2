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
         style="background-color: deepskyblue">
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

            <a href="PatientServlet" class="btn btn-success">Add
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

                    <td>

                        <form action="PatientServlet" method="post">
                        <!--<a href="PatientServlet?uid=edit&patient_id=<c:out value='${Patient.patient_id}' />&first_name=<c:out value='${Patient.first_name}' />&last_name=<c:out value='${Patient.last_name}' />&tc_no=<c:out value='${Patient.tc_no}' />&date_of_birth=<c:out value='${Patient.date_of_birth}'/>&tel_no=<c:out value='${Patient.tel_no}' />&job=<c:out value='${Patient.job}' />&gender=<c:out value='${Patient.gender}' />&report_date=<c:out value='${Patient.report_date}' />&address=<c:out value='${Patient.address}' />">Edit</a>-->
                            <input type="hidden" name="patient_id" value="<c:out value='${Patient.patient_id}' />" required>
                            <input type="hidden" name="first_name" value="<c:out value='${Patient.first_name}' />" required>
                            <input type="hidden" name="last_name" value="<c:out value='${Patient.last_name}' />" required>
                            <input type="hidden" name="tc_no" value="<c:out value='${Patient.tc_no}' />" required>
                            <input type="hidden" name="date_of_birth" value="<c:out value='${Patient.date_of_birth}' />" required>
                            <input type="hidden" name="tel_no" value="<c:out value='${Patient.tel_no}' />" required>
                            <input type="hidden" name="job" value="<c:out value='${Patient.job}' />" required>
                            <input type="hidden" name="gender" value="<c:out value='${Patient.gender}' />" required>
                            <input type="hidden" name="report_date" value="<c:out value='${Patient.report_date}' />" required>
                            <input type="hidden" name="address" value="<c:out value='${Patient.address}' />" required>
                            <input type="hidden" placeholder="Adres Giriniz" name="uid" value="edit" required>
                            <button class="button">Edit</button>

                        </form>
                        <form action="PatientServlet" method="post">
                       <!-- <a href="PatientServlet?uid=delete&patient_id=<c:out value='${Patient.patient_id}' />">Delete</a>-->
                            <input type="hidden" name="patient_id" value="<c:out value='${Patient.patient_id}' />" required>


                            <button class="button" >Delete</button>

                                <input type="hidden" name="uid" value="delete" required>

                        </form>

                        </td>
                </tr>
            </c:forEach>

            </tbody>

        </table>
    </div>
</div>
</body>

</html>