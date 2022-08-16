package javapart;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertPatient {
    private final String url = "jdbc:postgresql://localhost:5433/doctors-db";
    private final String user = "postgres";
    private final String pas = "test";

    private static final String INSERT_USERS_SQL = "INSERT INTO patients" +
            "  ( first_name, last_name, tc_no, date_of_birth, tel_no, gender, adress) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?);";

    public void insertRecord(String first_name, String last_name, long tc_no, String date_of_birth, long tel_no, String gender, String adress) throws SQLException, ClassNotFoundException {
        System.out.println(INSERT_USERS_SQL);
        // Step 1: Establishing a Connection


        Connection connection= null;
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(url, user, pas) ;

        // Step 2:Create a statement using connection object
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
        preparedStatement.setString(1, first_name);
        preparedStatement.setString(2, last_name);
        preparedStatement.setLong(3, tc_no);
        preparedStatement.setString(4, date_of_birth);
        preparedStatement.setLong(5, tel_no);
        preparedStatement.setString(6, gender);
        preparedStatement.setString(7, adress);

        System.out.println(preparedStatement);
        // Step 3: Execute the query or update query
        preparedStatement.executeUpdate();

        // Step 4: try-with-resource statement will auto close the connection.



    }

}
