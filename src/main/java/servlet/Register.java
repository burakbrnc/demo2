package servlet;

import javapart.Insert;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;



@WebServlet(name = "Register", value = "/Register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("sd");
        getServletContext().getRequestDispatcher("/Register.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Insert toDb = new Insert();

        String username = request.getParameter("username");
        String password =request.getParameter("pass");
        try {
            toDb.insertRecord(username,password);
        } catch (SQLException | ClassNotFoundException e) {}
        getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);


        System.out.println(password + username);

        /*InsertPatient patient = new InsertPatient();
        String first_name =request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        long tc_no = Long.parseLong(request.getParameter("tc_no"));
        String date_of_birth = request.getParameter("date_of_birth");
        long tel_no = Long.parseLong(request.getParameter("tel_no"));
        String job = request.getParameter("job");
        String gender = request.getParameter("gender");
        String report_date = request.getParameter("report_date");
        String address = request.getParameter("address");
        try {
            patient.insertRecord(first_name,last_name,tc_no,date_of_birth,tel_no,job,gender,report_date,address);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        */

    }
    }

