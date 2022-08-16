package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

import dbdisplaypart.Patient;
import dbdisplaypart.PatientErisim;
import javapart.Kullanici;
import javapart.Erisim;


@WebServlet(name = "Login", urlPatterns = "/login")

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String kullanici=request.getParameter("kullanici");
        String sifre=request.getParameter("sifre");
        Kullanici k=new Erisim().getirKullanici(kullanici,sifre);

        if(k!=null) {
            request.getSession().setAttribute("kullanici", k);
            List<Patient> listPatient = new PatientErisim().selectallPatient();
            request.setAttribute("listPatient",listPatient);


            request.getRequestDispatcher("anasayfa.jsp").forward(request,response);;
        }
        else {
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
        // Patient a = new PatientErisim().getirPatient();








    }






}
