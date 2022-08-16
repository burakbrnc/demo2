package servlet;

import javapart.InsertPatient;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet (name = "RegisterPatient", value = "/RegisterPatient")
public class RegisterPatient extends HttpServlet {
    public RegisterPatient() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/RegisterPatient.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InsertPatient patient = new InsertPatient();
        String firstname =request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String birth = request.getParameter("birth");
        long tel = Long.parseLong(request.getParameter("tel"));
        long tc = Long.parseLong(request.getParameter("tc"));
        String adres = request.getParameter("adres");
        String job = request.getParameter("job");
        String gender = request.getParameter("gender");
        try {
            patient.insertRecord(firstname,lastname,tc,birth,tel,gender,adres);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
