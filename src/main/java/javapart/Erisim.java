package javapart;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static java.sql.DriverManager.getConnection;



public class Erisim {

    public Kullanici getirKullanici(String Username,String Password){


        Kullanici k=null;


        try {
            Class.forName("org.postgresql.Driver");
            Connection c = getConnection("jdbc:postgresql://localhost:5433/doctors-db",
                    "postgres", "test");

            String query = "select id, username,password from doctor where username=? and password=?";
            PreparedStatement pst = c.prepareStatement(query);
            pst.setString(1, Username);
            pst.setString(2, Password);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                k=new Kullanici(rs.getInt("id"),rs.getString("username"), rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return k;
    }






}
