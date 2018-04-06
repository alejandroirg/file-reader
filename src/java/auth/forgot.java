/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AlejandroIvan
 */
@WebServlet(name = "forgot_1", urlPatterns = {"/forgot_1"})
public class forgot extends HttpServlet {

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
            out.println("<title>Servlet forgot</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet forgot at " + request.getContextPath() + "</h1>");
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
    String email = request.getParameter("email");
    try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h4>" + email + "</h4>");
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
     String sql1 = "SELECT pregunta FROM usuarios WHERE email='"+email+"'";
     // Ejecuta una consulta que devuelve resultados                
     ResultSet rs = st.executeQuery(sql1); 
     out.print("<form action='forgot2' method='POST'>");
     out.print("<input type='hidden' name='email' value='"+email+"'>");
     String pregunta = "";
     while (rs.next()) {
     out.print(rs.getString("pregunta"));
     pregunta = rs.getString("pregunta");
     }
     out.println("<input type='hidden' name='pregunta' value='" + pregunta + "'>");       
     out.println("<input type='text' name='respuesta' placeholder='Respuesta'>");
     out.println("<input type='submit' value='Enviar'>");
     out.println("</form>");
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
