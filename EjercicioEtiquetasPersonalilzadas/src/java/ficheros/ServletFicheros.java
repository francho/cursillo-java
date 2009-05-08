/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ficheros;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AdminLocal
 */
public class ServletFicheros extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            String s =this.getServletContext().getRealPath("/") + "/ficheros";
            File raiz = new File(s);
            if(!(raiz.exists()))
            {
                raiz.mkdir();
            }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            // TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletFicheros</title>");  
            out.println("</head>");
            out.println("<body>");

            out.println("<form method=\"post\" action=\"/EjercicioServlets/ServletFicheros\">");
            out.println("<center>");
            out.println("<input type=\"text\" name=\"nombreDirectorio\"/>");
            out.println("<input type=\"submit\" value=\"Crear Directorio\"/>");
            out.println("</br>");
            out.println("<input type=\"text\" name=\"nombreArchivo\"/>");
            out.println("<input type=\"submit\" value=\"Crear Archivo\"/>");

            Enumeration paramNames = request.getParameterNames();
            while (paramNames.hasMoreElements())
            {
                String fichero = "";
                String directorio = "";
                String paramName = (String) paramNames.nextElement();
                if(paramName.equals("nombreDirectorio"))
                {
                    directorio = request.getParameter(paramName);
                }
                if(paramName.equals("nombreArchivo"))
                {
                    fichero = request.getParameter(paramName);
                }
                if(!(directorio.equals("")))
                {
                    File f = new File(raiz,directorio);
                    if(!(f.exists()))
                    {
                        f.mkdir();
                    }
                }
                if(!(fichero.equals("")))
                {
                    File f = new File(raiz,fichero);
                    if(!(f.exists()))
                    {
                        f.createNewFile();
                    }
                }
            }
            out.println("</br>");
            out.println("Directorio raiz: " + raiz.getAbsolutePath());
            out.println("</br>");
            out.println("</br>");
            out.println("<table border=1>");
            out.println("<tr><td>Nombre</td><td>Tipo</td></tr>");
            for(File f : raiz.listFiles())
            {
                out.println("<tr><td>" + f.getName() + "</td><td>");
                if(f.isDirectory())
                {
                    out.println("Directorio</td></tr>");
                }
                else
                {
                    out.println("Archivo</td></tr>");
                }
            }
            
            out.println("</table>");
            out.println("</center>");
            out.println("</form>");
            out.println("<h1>Servlet ServletFicheros at " + request.getContextPath () + "</h1>");
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
