/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class Directorio extends HttpServlet {

    String dirIni = "";


    // Cargamos los valores iniciales
    @Override
    public void init() {

        // Cargamos el directorio de datos donde vamos a trabajar
        dirIni = this.getServletContext().getRealPath("/") + "datos";
        File raiz = new File(dirIni);

        // Si no existe lo creamos
        if( ! raiz.exists() ) {
            raiz.mkdir();
        }
  
        
    }

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            String tit = "Listado directorio " + (new File(dirIni)).getAbsolutePath();

            out.println("<html>");
            out.println("<head>");
            out.println("<style type=\"text/css\">");
            out.println("   body { ont-family: Helvetica, sans-serif; font-size: 10px; }");
            out.println("   .archivo { color: green; } ");
            out.println("   .directorio { color: blue; }");
            out.println("   table { border: 1px solid black; }");
            out.println("   th { border-bottom: 1px solid gray; }");
            out.println("   td { border-bottom: 1px dotted gray; }");
            out.println("   h2 { margin-bottom: 0px; background-color: black; color: white; padding-left: 5px; width: 150; font-size: 1.2em;} ");
            out.println("</style>");
            out.println("<title>" + tit + "</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h1>" + tit + "</h1>");

            // Formulario
            out.println("<form action=\"Directorio\" method=\"GET\">");
            out.println("<input type=\"text\" name=\"nomDir\">");
            out.println("<input type=\"submit\" name=\"accion\" value=\"Crear Directorio\">");
            out.println("<input type=\"text\" name=\"nomFich\">");
            out.println("<input type=\"submit\" name=\"accion\" value=\"Crear Fichero\">");
            out.println("</form>");


            // Recorremos los ficheros

            out.println("<h2>" + (new File(dirIni)).getAbsolutePath() + "</h2>");

            out.println("<table><tr><th>Nombre</th><th>Tipo</th></tr>");
            File dir = new File(dirIni);
            for (File fich : dir.listFiles()) {
                String tipo = "desconocido";
                if (fich.isDirectory()) {
                    tipo = "directorio";
                } else if (fich.isFile()) {
                    tipo = "archivo";
                }

                out.println("<tr class=\"" + tipo + "\"><td>" + fich.getName() + "</td><td>" + tipo + "</td></tr>");
            }
            out.print("</table>");


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

/* Movido al constructor

        // Cargamos el directorio de datos donde vamos a trabajar
        dirIni = this.getServletContext().getRealPath("/") + "datos";
        File raiz = new File(dirIni);

        // Si no existe lo creamos
        if( ! raiz.exists() ) {
            raiz.mkdir();
        }

*/

        PrintWriter out = response.getWriter();

        String accion = request.getParameter("accion");

        if (accion != null) {
            if (accion.equals("Crear Directorio")) {

                String nomDir = request.getParameter("nomDir");

                if (nomDir != null && !nomDir.equals("")) {
                    String d = (new File(dirIni)).getAbsolutePath() + "/" + nomDir;
                    File dir = new File(d);
                    if(!dir.exists()) { 
                        dir.mkdir();
                    }
                }
            } else if (accion.equals("Crear Fichero")) {
                String nomFich = request.getParameter("nomFich");

                if (nomFich != null && !nomFich.equals("")) {
                    String f = (new File(dirIni)).getAbsolutePath() + "/" + nomFich;
                    File fich = new File(f);
                    if(!fich.exists()) { 
                        fich.createNewFile();
                    }
                }
            }
        }

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
