package javapart;

import java.sql.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.sql.DriverManager.getConnection;

import javapart.Kullanici;

import java.util.Scanner;

public class Erisim {

    public Kullanici getirKullanici(String Username,String Password){

        Scanner dinle = new Scanner(System.in);
        String a;
        Kullanici k=null;

        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = getConnection("jdbc:postgresql://localhost:5432/idpw",
                    "postgres", "burak586a");

            String query = "select user_id, username,password from idpw where username=? and password=?";
            PreparedStatement pst = c.prepareStatement(query);
            pst.setString(1, Username);
            pst.setString(2, Password);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                k=new Kullanici(rs.getInt("user_id"),rs.getString("Username"), rs.getString("password"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return k;
    }






}
