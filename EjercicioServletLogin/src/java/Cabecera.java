/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrador
 */
public class Cabecera extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();


        ServletContext contexto = getServletContext();
        out.println("<html>");
        out.println("<head>");
        out.println("<style type=\"text/css\">");
        out.println("   body { font-family: Helvetica, sans-serif; font-size: 10px; }");
        out.println("   #pagina { width: 400px; margin: 0px auto; margin-top: 60px; border:1px dotted black; padding: 0px;}");
        out.println("   #cabecera { background-color: #eeeeee ; margin: 0px; text-align: right; }");
        out.println("   #cuerpo { padding: 5px; text-align: center}");
        out.println("   #cuerpo p { text-align: justify}");
        out.println("   #pie p { text-align: center}");
        

        out.println("</style>");
        out.println("<title>" + contexto.getAttribute("titulo") + "</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id=\"pagina\">");
        out.println("<div id=\"cuerpo\">");

        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("login");

        out.println("<div id=\"cabecera\">");
        if (login == null) {
            out.println("usuario no identificado<br>");
            out.println("<a href=\"Login\">Identificarse</a>");
        } else {
            out.println("Bienvenido, " + login + "<br>");
            out.println("<a href=\"Logout\">Salir</a>");
        }
        out.println("</div>");

        out.println("<div id=\"cuerpo\">");
        out.println("<h1>" + this.getServletContext().getAttribute("titulo") + "</h1>");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
