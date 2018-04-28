/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AlejandroIvan
 */
@WebServlet(name = "form", urlPatterns = {"/form"})
public class form extends HttpServlet {

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
            out.println("<title>Servlet form</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet form at " + request.getContextPath() + "</h1>");
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
        String fiscal = request.getParameter("fiscal").replace("\n", "").replace("\r", "");
        String csd = request.getParameter("csd").replace("\n", "").replace("\r", "");
        String emision = request.getParameter("emision").replace("\n", "").replace("\r", "");
        
        String cantidad = request.getParameter("cantidad").replace("\n", "").replace("\r", "");
        String unidad = request.getParameter("unidad").replace("\n", "").replace("\r", "");
        String descripcion = request.getParameter("descripcion").replace("\n", "").replace("\r", "");
        String preciounitario = request.getParameter("preciounitario").replace("\n", "").replace("\r", "");
        String importe = request.getParameter("importe").replace("\n", "").replace("\r", "");

         try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");  
            out.println("<link rel='stylesheet' type='text/css' href='main.css'>");
            out.println("<link href='https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900' rel='stylesheet'>");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='separator'></div>");
            out.println("<div class='container'>");
            out.println("<h1>Webpage Form</h1>");
            out.println("<form action='finish' method='POST'>");
            out.println("<input class='input' type='text' name='fiscal' id='fiscal'><br>");
            out.println("<input class='input' type='text' name='csd' id='csd'><br>");
            out.println("<input class='input' type='text' name='emision' id='emision'><br>");
            
            out.println("<input class='input' type='text' name='cantidad' id='cantidad'><br>");
            out.println("<input class='input' type='text' name='unidad' id='unidad'><br>");
            out.println("<input class='input' type='text' name='descripcion' id='descripcion'><br>");
            out.println("<input class='input' type='text' name='preciounitario' id='preciounitario'><br>");
            out.println("<input class='input' type='text' name='importe' id='importe'><br>");
            
            out.println("<input type='submit' value='Finish' class='submit'>");
            out.println("</form>");
            out.println("</div>");
            out.println("</body>");
            out.println("<script>");
            out.println("document.getElementById('fiscal').value = '" + fiscal + "'");
            out.println("document.getElementById('csd').value = '" + csd + "'");
            out.println("document.getElementById('emision').value = '" + emision + "'");
            out.println("document.getElementById('cantidad').value = '" + cantidad + "'");
            out.println("document.getElementById('unidad').value = '" + unidad + "'");
            out.println("document.getElementById('descripcion').value = '" + descripcion + "'");
            out.println("document.getElementById('preciounitario').value = '" + preciounitario + "'");
            out.println("document.getElementById('importe').value = '" + importe + "'");
            out.println("</script>");
            out.println("</html>"); 
     }catch(Exception ex){ex.printStackTrace();}
            
        processRequest(request, response);
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
