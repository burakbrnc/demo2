package javapart;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

    public class Insert {
    private final String url = "jdbc:postgresql://localhost:5433/doctors-db";
    private final String user = "postgres";
    private final String pas = "test";

    private static final String INSERT_USERS_SQL = "INSERT INTO doctor" +
            "  ( firstname, lastname, username, password) VALUES " +
            " (?, ?, ?, ?);";

    public static void main(String[] argv) throws SQLException {
        Insert createTableExample = new Insert();
    }

    public void insertRecord(String firstname, String lastname, String username, String password) throws SQLException, ClassNotFoundException {
        System.out.println(INSERT_USERS_SQL);
        // Step 1: Establishing a Connection


                Connection connection= null;
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, user, pas) ;

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, password);

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            preparedStatement.executeUpdate();

        // Step 4: try-with-resource statement will auto close the connection.



    }


}

