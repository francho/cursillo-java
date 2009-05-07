<%-- 
    Document   : usuarioNuevo
    Created on : 07-may-2009, 11:22:54
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%! String titulo = "Nuevo usuario";%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="WEB-INF/jspf/head.jspf" %>
    </head>
    <body>
        <%@ include file="WEB-INF/jspf/cabecera.jspf" %>

        <form action="usuarioNuevoValidar.jsp">
            Login: <input type="text" name="login"><br/>
            Clave: <input type="password" name="clave"><br/>
            Nombre: <input type="text" name="nombreCompleto"><br/>
            <input type="submit" value="Crear Cuenta">
        </form>


        <%@ include file="WEB-INF/jspf/pie.jspf" %>
    </body>
</html>
