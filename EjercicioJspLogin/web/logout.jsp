<%-- 
    Document   : logout
    Created on : 06-may-2009, 10:42:17
    Author     : Administrador
--%>
<%
    session.invalidate();

    response.sendRedirect(application.getContextPath() + "/index.jsp");
%>