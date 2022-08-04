<%--
  Created by IntelliJ IDEA.
  User: burak
  Date: 2.08.2022
  Time: 09:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <!--css files-->
    <link href="jquery-ui/jquery-ui.min.css" rel="stylesheet" type="text/css">
    <link href="jtable/themes/metro/blue/jtable.css" rel="stylesheet" type="text/css">
    <!--js files-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
    <script src="jtable/jquery.jtable.min.js" type="text/javascript"></script>
</head>
<body>
<div id="PatientTableContainer"></div>


<script type="text/javascript">
    $(document).ready(function () {
        $('#PatientTableContainer').jtable({
            title: 'Table of patients',
            actions: {
                listAction: '/GettingStarted/PersonList',
                createAction: '/GettingStarted/CreatePerson',
                updateAction: '/GettingStarted/UpdatePerson',
                deleteAction: '/GettingStarted/DeletePerson'
            },
            fields: {
                patient_id: {
                    key: true,
                    list: false
                },
                first_name: {
                    title: 'first_Name',
                    width: '40%'
                },
                last_name: {
                    title: 'last_Name',
                    width: '40%'
                },
                tc_no: {
                    title: 'tc_no',
                    width: '20%'
                },

                date_of_birth: {
                    title: 'date_of_birth',
                    width: '30%',
                    type: 'date',
                    create: false,
                    edit: false
                },
                tel_no: {
                    title: 'tel_no',
                    width: '20%'
                },
                job: {
                    title: 'job',
                    width: '40%'
                },
                gender: {
                    title: 'gender',
                    width: '40%'
                },

                report_date: {
                    title: 'report_date',
                    width: '30%',
                    type: 'date',
                    create: false,
                    edit: true
                }
                address: {
                    title: 'address',
                    width: '40%'
                },
            }
        });
    });
</script>





</body>
</html>
