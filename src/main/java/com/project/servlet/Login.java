package com.project.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Connection conn;
    private PreparedStatement pstmt;

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
            pstmt = conn.prepareStatement("SELECT * FROM Customers WHERE email = ? AND password = ?");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Obtain parameters from the client
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            if (email == null || email.trim().isEmpty() || password == null || password.trim().isEmpty()) {
                out.println("<html><body>");
                out.println("<h3>Email and password are required</h3>");
                out.println("</body></html>");
            } else {
                // Set the parameters for the PreparedStatement
                pstmt.setString(1, email);
                pstmt.setString(2, password);

                // Execute the query
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    // Successful login
                    HttpSession session = request.getSession();
                    session.setAttribute("user", rs.getString("name")); // Store user's name in session
                    response.sendRedirect("index.jsp"); // Redirect to home page
                } else {
                    // Invalid credentials
                    out.println("<html><body>");
                    out.println("<h3>Invalid email or password</h3>");
                    out.println("</body></html>");
                }
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
