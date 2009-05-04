/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.random.servlets.mytunes;

import java.io.*;
import java.net.*;

import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author ernesto.cuevas
 */
public class Indice extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion=request.getSession();
        String nombre="";
        String aux;
        Enumeration parametrosSesion=sesion.getAttributeNames();
        while(parametrosSesion.hasMoreElements())
        {
            if(((String)parametrosSesion.nextElement()).equals("nombre"))
            {
                nombre=(String) sesion.getAttribute("nombre");
            }
        }
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Indice</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<table>");
            out.println("<right>");
            out.println("<tr>");
            if(nombre.equals(""))
            {
                out.println("<td><a href=\"/ServletsFinal/Login\">Login</a></td>");
                out.println("<td><a href=\"/ServletsFinal/Registrar\">Registrar</a></td>");
            }
            else
            {
                out.println("<td>Saludos, "+nombre+"</td>");
            }
            out.println("</tr>");
            out.println("</right>");
            out.println("</table>");
            out.println("<h1>Servlet Indice at " + request.getContextPath () + "</h1>");
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
