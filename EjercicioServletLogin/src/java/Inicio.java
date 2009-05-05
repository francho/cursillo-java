/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrador
 */
public class Inicio extends HttpServlet {
   
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

            // Cogemos el contexto
            ServletContext sc = this.getServletContext();
            // Luego el recurso
            RequestDispatcher rd = sc.getRequestDispatcher("/Cabecera");
            
            sc.setAttribute("titulo", "Pagina Inicio");
            
            rd.include(request, response);


            // Ahora el contenido de nuestra página

            out.println("<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent felis turpis, lacinia id tempus ac, consectetur sit amet quam. Cras imperdiet fringilla egestas. Vivamus iaculis purus ac felis congue id adipiscing eros pharetra. Integer facilisis vulputate lorem vel facilisis. Cras tincidunt feugiat lorem, vel commodo neque dapibus a. Curabitur nec est diam. Etiam quis dui at nisl dignissim adipiscing nec vel tortor. Proin enim risus, ullamcorper sit amet tincidunt euismod, scelerisque et purus. Integer ultricies nisi at nibh ultricies vitae pulvinar purus vestibulum. Proin malesuada venenatis libero. In in urna justo, vitae aliquam ipsum. Quisque vehicula tristique luctus. Sed sit amet lectus eget arcu fringilla semper adipiscing ut enim. Cras egestas fermentum nisi in elementum. Vestibulum et purus nibh. Aliquam lobortis congue purus ut convallis. Nunc felis est, consectetur quis facilisis pulvinar, aliquet sed urna. Phasellus ac lacus eget lacus rutrum venenatis.</p>");
            out.println("<p>Maecenas facilisis cursus nunc et sollicitudin. Sed lorem eros, aliquet a pellentesque non, molestie vel augue. Fusce quis nunc diam, aliquet dignissim neque. Aliquam et congue enim. Nulla feugiat accumsan risus, sed pretium libero blandit eu. In eget arcu massa, eu interdum magna. Donec bibendum bibendum libero vitae bibendum. Nullam nec nibh massa. Proin ac magna in lorem placerat condimentum quis a purus. Sed fermentum velit quis mauris eleifend dictum. Nam vehicula velit id justo elementum eleifend.</p>");
            out.println("<p>Ut vehicula, nulla a placerat congue, nisi urna fringilla massa, non volutpat orci massa vitae mauris. Sed adipiscing, nulla eget pharetra consequat, quam sapien bibendum magna, at dictum diam justo eget dui. Praesent sagittis iaculis rhoncus. Suspendisse euismod blandit iaculis. Fusce vel turpis risus. Curabitur vulputate fermentum posuere. Suspendisse ac orci magna, eget tempus urna. Nulla tempor dui ac massa ultrices vitae commodo tellus imperdiet. Nulla faucibus ullamcorper scelerisque. Sed elit urna, vulputate in cursus ac, laoreet non diam. Etiam malesuada dapibus turpis, eu interdum dui varius at. Nunc rutrum ligula magna, et aliquet lectus. Curabitur nec massa enim, in pretium nunc. Donec at enim at mi porta ultrices. Cras sollicitudin lacus sit amet magna porttitor id posuere arcu faucibus. Ut volutpat massa ac magna imperdiet scelerisque. Pellentesque vel semper dui. Nullam hendrerit adipiscing enim, sit amet malesuada dolor consectetur vitae.</p>");
            out.println("<p>Maecenas convallis posuere aliquam. Donec purus orci, mattis mattis lacinia eget, euismod a dolor. Sed non tempus sem. Donec molestie malesuada euismod. Donec sed sem neque, rutrum commodo eros. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Morbi sem lorem, eleifend pulvinar dapibus ut, aliquam eu nulla. Nunc feugiat vestibulum congue. Vestibulum a nunc sem. Aliquam tincidunt dapibus neque eget accumsan. Nam ac nisl ac ligula semper aliquet in sit amet elit. Aliquam ac justo est. Etiam scelerisque velit ac ante malesuada sagittis. Nullam eu bibendum magna. Donec leo libero, dignissim cursus luctus eu, blandit vitae quam. Sed eu posuere mauris. Etiam molestie risus eu mauris pretium interdum. Maecenas eu libero non augue egestas mollis. Suspendisse aliquam mollis mauris, a aliquam libero convallis in. Etiam at nibh eget arcu convallis pharetra ut vel neque.</p>");
            out.println("<p>Vestibulum a massa elit. Aliquam id lacus sit amet magna malesuada posuere. In suscipit, nisi vel facilisis ornare, orci nunc malesuada enim, ac suscipit sem nibh at magna. Aenean pharetra, eros nec tristique semper, arcu dui molestie nunc, eu malesuada ipsum tortor id turpis. Mauris at urna diam. Sed a lorem vitae arcu sollicitudin accumsan ac quis felis. Curabitur eu nisl nec nibh imperdiet consequat. Morbi tempus tellus vel lorem eleifend quis pellentesque tellus porta. In id lorem elit. Sed eu massa velit. Aenean sagittis justo vitae sapien venenatis scelerisque vulputate lectus malesuada.</p>");
            


            rd = sc.getRequestDispatcher("/Pie");
            rd.include(request,response);
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
