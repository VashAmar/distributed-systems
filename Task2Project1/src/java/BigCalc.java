/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigInteger;


/**
 *
 * @author Vashista
 */
@WebServlet(urlPatterns = {"/BigCalc"})
public class BigCalc extends HttpServlet {

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
            out.println("<title>Servlet BigCalc</title>");            
            out.println("</head>");
            out.println("<body>");
            String option = request.getParameter("choice");
            

            
            try{
            BigInteger xBig = new BigInteger(request.getParameter("xvalue"));
            BigInteger yBig = new BigInteger(request.getParameter("yvalue"));
            
                
            switch (option) {
                case "add":
                    out.print(xBig + " plus " + yBig + " = " + xBig.add(yBig));
                    break;
                case "multi":
                    out.println(xBig + " times " + yBig + " = " + xBig.multiply(yBig));
                    break;
                case "relativelyPrime":
                    BigInteger p1 = new BigInteger("1");
                    
                    if(xBig.gcd(yBig).equals(p1)){
                        out.println("The values are relatively prime");
                    }
                    else{
                        out.println("The values are not relatively prime, they share the value " + xBig.gcd(yBig) + " as their least common factor");
                    
                    }
                    
                    break;
                case "mod":
                    out.println(xBig + " mod " + yBig + " = " + xBig.mod(yBig));
                    break;
                case "modInverse":  // Need to fix X Must Be Negative. Y Must Be Positive Values must be coprime??
                   BigInteger p2 = new BigInteger("1");
                    
                    if(xBig.gcd(yBig).equals(p2)){
                        out.println("The Modular inverse of " + xBig + " and " + yBig + " is " + xBig.modInverse(yBig));
                        
                    }
                    else{
                        out.println("The values are not relatively prime, values must be relaively prime to calculate the modular inverse!!");
                    
                    }
                   
                    break;
                case "power":
                    out.println(xBig + "^" + yBig + " = ");
                    out.println(xBig.pow(Integer.parseInt(request.getParameter("yvalue"))));
                    break;
                }
            }
            catch(NumberFormatException e){
                out.println("You didn't put in a valid value");
            }
            out.println("<br>");
            out.println("<a href='/Project1Task2/index.jsp'>Go Back</a>");
            
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
