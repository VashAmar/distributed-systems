/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.misc.BASE64Encoder;

/**
 *
 * @author neer
 */
@WebServlet(urlPatterns = {"/ComputeHashes"})
public class ComputeHashes extends HttpServlet {

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
            throws ServletException, IOException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
            String isMD5 = request.getParameter("hash");
            String text = request.getParameter("text");
            String value1 = "";
            String value2= "";
            if(isMD5.equals("MD5")){
                value1 = "MD5 (hex): " + MD5Hex(text);
                value2 = "MD5 (Base 64)"+ MD5Base64(text);
            }
            else{
                value1 = "SHA-1 (hex) " + SHA1Hex(text);
                value2 = "SHA-1 (Base 64)" + SHA1Base64(text);
            }
        
            out.println("You entered: " + text);
            out.println("<br>");
            out.println(value1);
            out.println("<br>");
            out.println(value2);
            out.println("<br>");
            out.println("<a href='/Project1Task1/index.jsp'>Go Back</a>");
            out.println("</body>");
            out.println("</html>");
        }
        
        
    }
    
    public String MD5Hex(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = md.digest(text.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        String hex = "";
        
        for (int r = 0; r < thedigest.length; r++)
        {
            hex = Integer.toHexString(0xFF & thedigest[r]);
            if (hex.length() == 1)
                hexString.append('0');

            hexString.append(hex);
        }
        return hexString.toString().toUpperCase();
    }

        public String MD5Base64(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException{
          BASE64Encoder encoder = new BASE64Encoder();
          MessageDigest md = MessageDigest.getInstance("MD5");
          md.update(text.getBytes());
          byte[] base64 = md.digest();
          String result = encoder.encodeBuffer(base64);
          return result;
          
        }
    public String SHA1Hex(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] thedigest = md.digest(text.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        String hex = "";
        
        for (int r = 0; r < thedigest.length; r++)
        {
            hex = Integer.toHexString(0xFF & thedigest[r]);
            if (hex.length() == 1)
                hexString.append('0');

            hexString.append(hex);
        }
        return hexString.toString().toUpperCase();
    }        
        public String SHA1Base64(String text) throws NoSuchAlgorithmException, UnsupportedEncodingException{
          BASE64Encoder encoder = new BASE64Encoder();
          MessageDigest md = MessageDigest.getInstance("SHA-1");
          md.update(text.getBytes());
          byte[] base64 = md.digest();
          String result = encoder.encodeBuffer(base64);
          return result;  
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
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ComputeHashes.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ComputeHashes.class.getName()).log(Level.SEVERE, null, ex);
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



