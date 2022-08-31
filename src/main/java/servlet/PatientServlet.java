package servlet;

import dbdisplaypart.Patient;
import dbdisplaypart.PatientErisim;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.Locale;

@WebServlet(name = "PatientServlet", value = "/PatientServlet/*")
public class PatientServlet extends HttpServlet {

    DateTimeFormatter dateFormatter =
            new DateTimeFormatterBuilder()
                    .parseCaseInsensitive()
                    .appendPattern("yyyy-MM-dd")
                    .toFormatter(Locale.ENGLISH);
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
            case "edit":
                try {
                    this.showEditForm(request, response);
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
        String name = request.getParameter("first_name");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("RegisterPatient.jsp") ;
        requestDispatcher.forward(request,response);
    }

    protected void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("anasayfa.jsp") ;
        requestDispatcher.forward(request,response);
    }

    public void insertPatient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {


        try {
            String name = request.getParameter("first_name");
            Patient newPatient = new Patient(request.getParameter("first_name"), request.getParameter("last_name"), Long.parseLong(request.getParameter("tc_no")), java.sql.Date.valueOf(LocalDate.parse((request.getParameter("date_of_birth")), dateFormatter)), Long.parseLong(request.getParameter("tel_no")), request.getParameter("job"), request.getParameter("gender"), java.sql.Date.valueOf(LocalDate.parse((request.getParameter("report_date")), dateFormatter)), request.getParameter("address"));
            patientErisim.insertPatient(newPatient);
            listPatient(request, response);
        }catch (Exception e){
            e.printStackTrace();
        }
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

        Patient p = new Patient();
        p.getFirst_name();


        try {
            //showEditForm(request, response);

            p.setPatient_id(Integer.parseInt(request.getParameter("patient_id")));
            p.setFirst_name(request.getParameter("first_name"));
            p.setLast_name(request.getParameter("last_name"));
            p.setTc_no(Long.parseLong(request.getParameter("tc_no")));
            p.setDate_of_birth(java.sql.Date.valueOf(LocalDate.parse((request.getParameter("date_of_birth")), dateFormatter)));
            p.setTel_no(Long.parseLong(request.getParameter("tel_no")));
            p.setJob(request.getParameter("job"));
            p.setGender(request.getParameter("gender"));
            p.setReport_date(java.sql.Date.valueOf(LocalDate.parse((request.getParameter("report_date")), dateFormatter)));
            p.setAddress(request.getParameter("address"));
            //Patient patient = new Patient(request.getParameter("first_name"), request.getParameter("last_name"), Long.parseLong(request.getParameter("tc_no")), java.sql.Date.valueOf(LocalDate.parse((request.getParameter("date_of_birth")), dateFormatter)), Long.parseLong(request.getParameter("tel_no")), request.getParameter("job"), request.getParameter("gender"), java.sql.Date.valueOf(LocalDate.parse((request.getParameter("report_date")), dateFormatter)), request.getParameter("address"));
            patientErisim.updatePatient(p);

            listPatient(request, response);
        }
        catch (Exception e){
            e.printStackTrace();
        }


    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int patient_id = Integer.parseInt(request.getParameter("patient_id"));
        Patient existingPatient = PatientErisim.selectPatient(patient_id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("UpdatePatient.jsp");
        request.setAttribute("Patient", existingPatient);
        dispatcher.forward(request, response);

    }
    }

