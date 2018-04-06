/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

/**
 *
 * @author AlejandroIvan
 */
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    //GET PARAMS
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h4>" + username + "</h4>");
            out.println("<h4>" + password + "</h4>");
            out.println("</body>");
            out.println("</html>");
    //DB CONNECTION
    try{
    try {
    Class.forName("com.mysql.jdbc.Driver");
    } catch (ClassNotFoundException ex) {
    out.print("No se encontro el Driver MySQL para JDBC.");
    }    
    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/filereader", "root", "");
    // Creamos el Statement para poder hacer consultas
    Statement st = cn.createStatement();
     // La consulta es un String con código SQL
     String sql1 = "SELECT * FROM usuarios";
     // Ejecuta una consulta que devuelve resultados                
     ResultSet rs = st.executeQuery(sql1);   
     while (rs.next()) {
     if(rs.getString("username").equals(username) && rs.getString("password").equals(password)){
     response.sendRedirect("home.html");
     }else{
     response.sendRedirect("index.html");
     }    
     }               
    }catch(Exception ex){
    out.print(ex);
    }
    }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
