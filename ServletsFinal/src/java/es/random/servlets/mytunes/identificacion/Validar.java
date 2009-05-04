/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package es.random.servlets.mytunes.identificacion;

import java.io.*;
import java.net.*;

import java.util.Enumeration;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author ernesto.cuevas
 */
public class Validar extends HttpServlet {
   
    /** 
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession sesion=request.getSession();
        sesion.setAttribute("nombre", request.getParameter("nombre"));
        Enumeration parametros=request.getParameterNames();
        boolean existeCookie=false;
        while(parametros.hasMoreElements())
        {
            if(((String)parametros.nextElement()).equals("reconocer"))
            {
                Cookie[] lasCookies=request.getCookies();
                for(int i=0;i<lasCookies.length;i++)
                {
                    if(lasCookies[i].getName().equals("ServletFinal"))
                    {
                        existeCookie=true;
                    }
                }
                if(!existeCookie)
                {
                    Cookie miCookie=new Cookie("ServletFinal",request.getParameter("nombre"));
                    miCookie.setMaxAge(31536000);
                    response.addCookie(miCookie);
                }
            }
        }
        response.sendRedirect("/ServletsFinal/Indice");
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
