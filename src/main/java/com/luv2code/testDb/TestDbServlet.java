package com.luv2code.testDb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet(name = "TestDbServlet")
public class TestDbServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get all the Db credentials
        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String username = "springstudent";
        String password = "springstudent";

        String driver = "com.mysql.cj.jdbc.Driver";

        try{
            // Connecting to the database
            System.out.println("Connecting to the database ... ");

            // Define the driver
            Class.forName(driver);

            // Connect to the database
            Connection myConn = DriverManager.getConnection(jdbcUrl, username, password);

            PrintWriter out = response.getWriter();
            out.println("SUCCESS!");

        }catch(Exception exc){
            exc.printStackTrace();
        }


    }
}
