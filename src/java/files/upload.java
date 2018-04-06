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
      for(String s : arr) {
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
