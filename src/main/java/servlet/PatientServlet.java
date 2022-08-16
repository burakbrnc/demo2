package servlet;

import dbdisplaypart.Patient;
import dbdisplaypart.PatientErisim;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PatientServlet", value = "/PatientServlet")
public class PatientServlet extends HttpServlet {
    private PatientErisim patientErisim;

    public PatientServlet() {
        this.patientErisim = new PatientErisim();

    }
    //form sayfasını yönlendiren method
    protected void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("anasayfa.jsp") ;
        requestDispatcher.forward(request,response);
    }
    public void insertPatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Patient newPatient = new Patient(Integer.parseInt(request.getParameter("patient_id")), request.getParameter("first_name"), request.getParameter("last_name"), Long.parseLong(request.getParameter("tc_no")), request.getParameter("date_of_birth"), Long.parseLong(request.getParameter("tel_no")), request.getParameter("job"), request.getParameter("gender"), request.getParameter("report_date"), request.getParameter("address"));
        patientErisim.insertPatient(newPatient);
        response.sendRedirect("list");//do get methoduna gönderiyor o da inserte sallıyor (calısıp calısmadıgından emin değilim)
    }

    public void deletePatient (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int patient_id = Integer.parseInt(request.getParameter("patient_id"));
        patientErisim.deletePatient(patient_id);
        response.sendRedirect("list");
    }
    public void listPatient (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
        List<Patient> listPatient = patientErisim.selectallPatient();
        request.setAttribute("listPatient",listPatient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("anasayfa.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action){
            case "/new":
                showNewForm(request,response);
                break;
            case "/insert":
                try {
                    insertPatient(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            case "/delete":
                try {
                    deletePatient(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            case "/update":
            default:
                try {
                    listPatient(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
        }


    }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
