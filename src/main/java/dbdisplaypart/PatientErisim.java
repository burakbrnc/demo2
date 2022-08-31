package dbdisplaypart;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PatientErisim {

    private static final String insert_patients_sql = "INSERT INTO patients" + "(first_name,last_name,tc_no,date_of_birth,tel_no,job,gender,report_date,address) values" + "(?,?,?,?,?,?,?,?,?);";
    private static final String update_patients_sql = "update patients set first_name = ?,last_name = ?,tc_no = ?,date_of_birth = ?,tel_no = ?, job=?, gender=?, report_date=?,address=?;";
    private static final String select_patient_by_id = "select * from patients where patient_id =?";
    private static final String select_all_patients = "select * from patients";
    private static final String delete_patients_sql = "delete from patients where patient_id = ?;";



    protected static Connection getConnection() {
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/idpw", "postgres", "burak586a");


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return c;
    }//CREATE, INSERT PATIENT

    public void insertPatient(Patient patient) throws SQLException {
        try (Connection c = getConnection();

            // first_name,last_name,tc_no,date_of_birth,tel_no,job,gender,report_date,address
             PreparedStatement preparedStatement = c.prepareStatement(insert_patients_sql)) {
            preparedStatement.setString(1, patient.getFirst_name());
            preparedStatement.setString(2, patient.getLast_name());
            preparedStatement.setLong(3, patient.getTc_no());
            preparedStatement.setDate(4, patient.getDate_of_birth());
            preparedStatement.setLong(5, patient.getTel_no());
            preparedStatement.setString(6, patient.getJob());
            preparedStatement.setString(7, patient.getGender());
            preparedStatement.setDate(8,  patient.getReport_date());
            preparedStatement.setString(9, patient.getAddress());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();
        }
    }

    //UPDATE PATIENT
    public void updatePatient(Patient patient) throws SQLException {
        boolean rowUpdated;
        try (Connection c = getConnection();
             PreparedStatement preparedStatement = c.prepareStatement(update_patients_sql)) {
            preparedStatement.setString(1, patient.getFirst_name());
            preparedStatement.setString(2, patient.getLast_name());
            preparedStatement.setLong(3, patient.getTc_no());
            preparedStatement.setDate(4, patient.getDate_of_birth());
            preparedStatement.setLong(5, patient.getTel_no());
            preparedStatement.setString(6, patient.getJob());
            preparedStatement.setString(7, patient.getGender());
            preparedStatement.setDate(8, patient.getReport_date());
            preparedStatement.setString(9, patient.getAddress());

            rowUpdated = preparedStatement.executeUpdate() > 0;


        }


    }
    //SELECT PATIENT BY ID
    public static Patient selectPatient(int patient_id) {
        Patient p = null;
        try (Connection c = getConnection();
             PreparedStatement preparedStatement = c.prepareStatement(select_patient_by_id)) {
            preparedStatement.setInt(1, patient_id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                p = new Patient(rs.getInt("patient_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getLong("tc_no"), rs.getDate("date_of_birth"), rs.getLong("tel_no"), rs.getString("job"), rs.getString("gender"), rs.getDate("report_date"), rs.getString("address"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return p;
    }
    //SELECT ALL PATIENTS



    public List<Patient> selectallPatient() {
        List<Patient> patientList = new ArrayList<Patient>();
        try (Connection c = getConnection();
             PreparedStatement preparedStatement = c.prepareStatement(select_all_patients)) {

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                patientList.add(new Patient(rs.getInt("patient_id"), rs.getString("first_name"), rs.getString("last_name"), rs.getLong("tc_no"), rs.getDate("date_of_birth"), rs.getLong("tel_no"), rs.getString("job"), rs.getString("gender"), rs.getDate("report_date"), rs.getString("address")));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patientList;
    }
    // DELETE PATIENT
    public boolean deletePatient(int patient_id) throws SQLException {
        boolean rowDeleted;
        try (Connection c = getConnection();
             PreparedStatement preparedStatement = c.prepareStatement(delete_patients_sql)) {

            preparedStatement.setInt(1, patient_id);
            rowDeleted = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return rowDeleted;
    }


}
















