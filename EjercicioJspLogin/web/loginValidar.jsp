<%! String titulo;%>
<%


        String login = request.getParameter("login");
        if (login != null && !login.equals("")) {

            HttpSession sesion = request.getSession(true);
            sesion.setAttribute("login", login);

            titulo = "Bienvenido " + login;

            String urlAnterior = (String) sesion.getAttribute("referer");

            out.println("Redirigiendo a " + urlAnterior + "...");

            response.sendRedirect(urlAnterior);


        } else {
           titulo = "Error de autentificacion";

%>
<%--
    Document   : loginValidar
    Created on : 06-may-2009, 10:36:04
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="WEB-INF/jspf/head.jspf" %>
    </head>
    <body>
        <%@ include file="WEB-INF/jspf/cabecera.jspf" %>

        <p>Debes introducir un nombre de usuario y contraseña validos</p>
        <p><a href="javascript:history.back();">Vuelve a intentarlo</a></p>

        <%@ include file="WEB-INF/jspf/pie.jspf" %>
    </body>
</html>

<% }%>