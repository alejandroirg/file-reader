/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 *
 * @author AlejandroIvan
 */
@WebServlet(name = "upload", urlPatterns = {"/upload"})
@MultipartConfig
public class upload extends HttpServlet {

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
            out.println("<title>Servlet upload</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet upload at " + request.getContextPath() + "</h1>");
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
    Part filePart = request.getPart("myFile"); // Retrieves <input type="file" name="file">
    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
    InputStream fileContent = filePart.getInputStream(); 
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
            out.println("<h1>Extracted Info</h1>");
               //Loading an existing document
      PDDocument document = PDDocument.load(fileContent);
      //Instantiate PDFTextStripper class
      PDFTextStripper pdfStripper = new PDFTextStripper();

      //Retrieving text from PDF document
      String text = pdfStripper.getText(document);
   
      //Here comes the action.
      String[] arr = text.split(" ");
      ArrayList<String> arr2 = new ArrayList<String>();
      boolean gotit = false;
      
      //Por todo el texto
       for(String s : arr) {   
       //out.println(s);
       if(gotit == true){
       out.println(s + "<br>");
       arr2.add(s);
       gotit = false;
       }else{
       if(s.equals("Fiscal:") || s.equals("CSD:") || s.equals("emisión:")){
       out.println(s + "<br>");
       gotit = true;
       }else{}   
       }
      }
       
      //Buscamos los elementos de la tabla con otro for
       int cont = 0;
       String cantidad = "";
       String unidad = "";
       String descripcion = "";
       String preciounitario = "";
       String importe = "";

       for(String s : arr){  
       //1 - Cantidad
       //2 - Unidad de Medida
       //3 - Descripción
       //4 - Precio Unitario
       //5 - Importe
     
       if(s.equals("°")){
       cont += 1;
       }else{
       
       switch(cont){
           case 1:
               cantidad += s + " "; 
               break;
           case 2:
               unidad += s + " ";
               break;
           case 3:
               descripcion += s + " ";
               break;
           case 4:
               preciounitario += s + " ";
               break;
           case 5:
               importe += s + " "; 
               break;
           default:
               break;
       }    
       
       if(cont == 5){
       cont = -100;
       }else{}}
       
       }
       
       out.println("Cantidad:" + "<br>");
       out.println(cantidad + "<br>");
       out.println("Unidad:" + "<br>");
       out.println(unidad + "<br>");
       out.println("Descripcion:" + "<br>");
       out.println(descripcion + "<br>");
       out.println("Precio Unitario:" + "<br>");
       out.println(preciounitario + "<br>");
       out.println("Importe:" + "<br>");
       out.println(importe + "<br>");
       
       arr2.add(cantidad);
       arr2.add(unidad);
       arr2.add(descripcion);
       arr2.add(preciounitario);
       arr2.add(importe);
       
      //Closing the document
      document.close();
               //
            BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		String line;
		try {
			br = new BufferedReader(new InputStreamReader(fileContent));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		out.println(sb.toString());
            out.println("<form action='form' method='POST'>");
            out.println("<input type='hidden' name='fiscal' value='"+ arr2.get(0) +"'>");
            out.println("<input type='hidden' name='csd' value='"+ arr2.get(1) +"'>");
            out.println("<input type='hidden' name='emision' value='"+ arr2.get(2) +"'>");
            
            out.println("<input type='hidden' name='cantidad' value='"+ arr2.get(3) +"'>");
            out.println("<input type='hidden' name='unidad' value='"+ arr2.get(4) +"'>");
            out.println("<input type='hidden' name='descripcion' value='"+ arr2.get(5) +"'>");
            out.println("<input type='hidden' name='preciounitario' value='"+ arr2.get(6) +"'>");
            out.println("<input type='hidden' name='importe' value='"+ arr2.get(7) +"'>");
           
            out.println("<input class='submit' type='submit' value='Send'>");
            out.println("</form>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>"); 
     }catch(Exception ex){ex.printStackTrace();}
    
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
