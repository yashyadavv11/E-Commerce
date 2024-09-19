package com.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/register")
public class Register extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private PreparedStatement pstmt;
    private Connection conn;

    @Override
    public void init() throws ServletException {
        super.init();
        initializeJdbc();
    }

    private void initializeJdbc() {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded");

            // Establish a connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "root");
            System.out.println("Database connected");

            // Create a PreparedStatement
            pstmt = conn.prepareStatement("INSERT INTO Customers (customer_id, name, email, password) VALUES (?, ?, ?, ?)");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Obtain parameters from the client
        String custid = request.getParameter("customer_id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            if (custid == null || name.trim().isEmpty() ||
                email == null || password.trim().isEmpty()) {
                out.println("<html><body>");
                out.println("<h3>Customer ID, name, email, and password are required</h3>");
                out.println("</body></html>");
            } else {
                // Set the parameters for the PreparedStatement
                pstmt.setString(1, custid);
                pstmt.setString(2, name);
                pstmt.setString(3, email);
                pstmt.setString(4, password);

                // Execute the PreparedStatement
                pstmt.executeUpdate();

                HttpSession session = request.getSession();
                out.println("<h3>Successfully registered. Please login.</h3>");
                response.sendRedirect("index.jsp");
                
                }
        } catch (SQLException ex) {
            out.println("<html><body>");
            out.println("<h3>Error: " + escapeHtml(ex.getMessage()) + "</h3>");
            out.println("</body></html>");
        } finally {
            out.close(); // Close the stream
        }
    }

    private String escapeHtml(String text) {
        if (text == null) {
            return null;
        }
        return text.replace("&", "&amp;")
                   .replace("<", "&lt;")
                   .replace(">", "&gt;")
                   .replace("\"", "&quot;")
                   .replace("'", "&#039;");
    }
}
