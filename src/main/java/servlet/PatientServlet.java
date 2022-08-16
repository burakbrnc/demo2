package servlet;

import dbdisplaypart.Patient;
import dbdisplaypart.PatientErisim;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PatientServlet", value = "/PatientServlet/*")
public class PatientServlet extends HttpServlet {
    Patient p = new Patient();
    public PatientErisim patientErisim;
    public PatientServlet() {
        this.patientErisim = new PatientErisim();
    }
    //form sayfasını yönlendiren method
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid = request.getParameter("uid");
        switch (uid){
            case "new":
                this.showNewForm(request, response);
                break;
            case "insert":
                try {
                    this.insertPatient(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                break;
            case "delete":
                try {
                    this.deletePatient(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "update":
                try {
                    this.updatePatient(request,response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "post" :
                doPost(request, response);
                break;
            default:
                try {
                    this.listPatient(request, response);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("RegisterPatient.jsp") ;
        requestDispatcher.forward(request,response);
    }

    protected void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("anasayfa.jsp") ;
        requestDispatcher.forward(request,response);
    }

    public void insertPatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        Patient newPatient = new Patient(1,"ahmet","a", 1L,"asd123", 3L,"a","m","adasd1","a");
        patientErisim.insertPatient(newPatient);
        listPatient(request, response);
    }

    public void deletePatient (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {

        int patient_id = Integer.parseInt(request.getParameter("patient_id"));
        patientErisim.deletePatient(patient_id);
        listPatient(request, response);
    }

    public void listPatient (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{

        List<Patient> listPatient = patientErisim.selectallPatient();
        request.setAttribute("listPatient",listPatient);
        RequestDispatcher dispatcher = request.getRequestDispatcher("anasayfa.jsp");
        dispatcher.forward(request,response);
    }
    public void updatePatient (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {



        }
    }

