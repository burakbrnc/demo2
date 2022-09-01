<jsp:useBean id="Patient" scope="request" type="dbdisplaypart.Patient"/>
<%--
  Created by IntelliJ IDEA.
  User: elifsen
  Date: 12.08.2022
  Time: 14:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-color: black;
        }

        * {
            box-sizing: border-box;
        }

        /* Add padding to containers */
        .container {
            padding: 16px;
            background-color: white;
        }

        /* Full-width input fields */
        input[type=text], input[type=date] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 22px 0;
            display: inline-block;
            border: none;
            background: #f1f1f1;
        }

        input[type=text]:focus, input[type=password]:focus{
            background-color: #ddd;
            outline: none;
        }

        /* Overwrite default styles of hr */
        hr {
            border: 1px solid #f1f1f1;
            margin-bottom: 25px;
        }

        /* Set a style for the submit button */
        .registerbtn {
            background-color: #04AA6D;
            color: white;
            padding: 16px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
            opacity: 0.9;
        }

        .registerbtn:hover {
            opacity: 1;
        }

        /* Add a blue text color to links */
        a {
            color: dodgerblue;
        }

        /* Set a grey background color and center the text of the "sign in" section */
        .signin {
            background-color: #f1f1f1;
            text-align: center;
        }
    </style>
</head>
<body>

<form action="PatientServlet" method="post">
    <div class="container">
        <h1>Hasta Kayıt Formu</h1>
        <p>Aşağıdaki bilgiler hasta kaydı için gereklidir</p>
        <hr>

        <label for="first_name"><b>İsim</b></label>
        <input type="hidden" placeholder="patient_id" name="patient_id" id="patient_id" value="${Patient.patient_id}" required>

        <input type="text" placeholder="first_name" name="first_name" id="first_name" value="${Patient.first_name}" required>

        <label for="last_name"><b>Soyadı</b></label>
        <input type="text" placeholder="Hasta Soyadı Giriniz" name="last_name" id="last_name" value="${Patient.last_name}" required>

        <label for="tc_no"><b>Tc Kimlik No</b></label>
        <input type="text" minlength="11" placeholder="T.C. Kimlik No" name="tc_no" id="tc_no" value="${Patient.tc_no}" required>
        <br>

        <label for="date_of_birth"><b>Doğum Tarihi</b></label>
        <input type="date" placeholder="Doğum Tarihi" name="date_of_birth" id="date_of_birth" value="${Patient.date_of_birth}" required>

        <label for="tel_no"><b> Cep Telefon Numarası</b></label>
        <input type="text" minlength="10" placeholder="Tel No (başında 0 olmadan) örn 555******" name="tel_no" id="tel_no" value="${Patient.tel_no}" required>

        <label for="job"><b>Meslek</b></label>
        <input type="text" placeholder="Meslek Giriniz" name="job" id="job" value="${Patient.job}" required>

        <label for="gender"><b>Cinsiyet</b></label>
        <input type="text" placeholder="Cinsiyet (kadın için K erkek için E giriniz)" name="gender" id="gender" value="${Patient.gender}" required>

        <label for="report_date"><b>rapor tarihi</b></label>
        <input type="date" placeholder="Rapor Tarihi" name="report_date" id="report_date" value="${Patient.report_date}" required>

        <label for="address"><b>Adres</b></label>
        <input type="text" placeholder="Adres Giriniz" name="address" id="address" value="${Patient.address}" required>
        <hr>

        <input type="hidden" name="uid" id="uid" value="update" required>

        <button type="submit" class="registerbtn"> Bilgileri Kaydet  </button>
    </div>


</form>

</body>
</html>




