<%-- 
    Document   : login
    Created on : 06-may-2009, 10:25:05
    Author     : Administrador
--%>
<%
session.setAttribute("referer", request.getHeader("referer"));
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<%! String titulo = "Acceso al sistema";%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="WEB-INF/jspf/head.jspf" %>
    </head>
    <body>
        <%@ include file="WEB-INF/jspf/cabecera.jspf" %>

        <form action="loginValidar.jsp">
            Login: <input type="text" name="login"><br/>
            Clave: <input type="password" name="clave"><br/>
            <input type="submit" value="entrar">
        </form>


        <%@ include file="WEB-INF/jspf/pie.jspf" %>
    </body>
</html>
