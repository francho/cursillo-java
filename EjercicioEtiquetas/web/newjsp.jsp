<%-- 
    Document   : newjsp
    Created on : 07-may-2009, 11:07:47
    Author     : AdminLocal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <jsp:useBean id="usuario"  class="sesion.Usuario" scope="session" />
<table border="0">
    <tbody>
        <tr>

            <% if(usuario == null)
                {
                out.print("Hola");
                }
            else
                {
                out.print("Adios");
                        }
  %>

            <% if (usuario.getValidado()) {%>
            <td>Bienvenido, <%=usuario.getNombreCompleto()%></td><td><a href="logout">Logout</a></td>
            <% } else {%>
            <td>Usuario no identificado</td><td><a href="login.jsp">Login</a></td>
            <% }%>
        </tr>
    </tbody>
</table>

    </body>
</html>
