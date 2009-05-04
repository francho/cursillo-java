/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.random.servlets.mytunes.identificacion;

import java.io.*;
import java.net.*;

import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author ernesto.cuevas
 */
public class Login extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Login</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<form method=\"post\" action=\"/ServletsFinal/Validar\">");
            out.println("<center>");
            out.println("<Table border=1>");
            out.println("<tr>");
            out.println("<td><left>Login</left></td>");
            out.println("<td><center><input type=\"textbox\" name=\"nombre\"></center></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td><left>Password</left></td>");
            out.println("<td><center><input type=\"password\" name=\"contraseña\"></center></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<input type=\"checkbox\" name=\"reconocer\"> Reconocerte autom&aacute;ticamente en visitas posteriores<br>");
            out.println("</center>");
            out.println("<center><input type=\"submit\" value=\"Validar\"></center>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
    * Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
    * Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
    * Returns a short description of the servlet.
    */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
