package servlet;

import dbdisplaypart.Patient;
import dbdisplaypart.PatientErisim;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

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
    protected void insertPatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Patient newPatient = new Patient(Integer.parseInt(request.getParameter("patient_id")), request.getParameter("first_name"), request.getParameter("last_name"), Long.parseLong(request.getParameter("tc_no")), request.getParameter("date_of_birth"), Long.parseLong(request.getParameter("tel_no")), request.getParameter("job"), request.getParameter("gender"), request.getParameter("report_date"), request.getParameter("address"));
        patientErisim.insertPatient(newPatient);
        response.sendRedirect("insert");//do get methoduna gönderiyor o da inserte sallıyor (calısıp calısmadıgından emin değilim)
    }



        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action){
            case "new":
                showNewForm(request,response);
                break;
            case "insert":

            case "delete":
            case "edit":
            case "update":
            default:
        }


        }




    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
