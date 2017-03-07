package com.kcs.first.example;

import java.sql.*;

/**
 * Created by User on 2017-03-07.
 */
public class MyFirstConnectionExample {
    public static void main(String[] args) {

        try {
            Connection connection =  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/kcs1", "root", "");

            if (connection !=null){
                System.out.println("CONNECTED");
                getStudents(connection);
            }


        } catch (SQLException e) {
            System.out.println("nepavyko prisijungti prie DB: " + e);
        }
    }

    private static void getStudents(Connection connection){
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery("SELECT * FROM students");
            while(resultSet.next()) {
                System.out.println("id: " + resultSet.getInt(1)
                        + " name: " + resultSet.getString("name")
                        + " surname: " + resultSet.getString(3)
                        + " phone: " + resultSet.getString(4)
                        + " email: " + resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
