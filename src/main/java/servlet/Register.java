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
        String firstname =request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password =request.getParameter("sifre");
        try {
            toDb.insertRecord(firstname,lastname,username,password);
        } catch (SQLException | ClassNotFoundException e) {
            // print SQL exception information

        }
        System.out.println(password+ firstname+ lastname+ username);
    }
}
