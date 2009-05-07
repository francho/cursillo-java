<%-- 
    Document   : usuarioNuevoValidar
    Created on : 07-may-2009, 11:26:06
    Author     : Administrador
--%>
<%@page import="es.fchx.login.Usuarios" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%! String titulo;%>
<jsp:useBean id="usuario" scope="page" class="es.fchx.login.UsuarioBean">
    <jsp:setProperty name="usuario" property="*"/>
</jsp:useBean>
<%

    Usuarios usuarios = new Usuarios();
    usuarios.nuevoUsuario(usuario);

    response.sendRedirect("/");
    
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
