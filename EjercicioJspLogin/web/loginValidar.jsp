<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="es.fchx.login.Usuarios" %>
<%! String titulo;%>
<jsp:useBean id="usuario" scope="page" class="es.fchx.login.UsuarioBean">
    <jsp:setProperty name="usuario" property="*"/>
</jsp:useBean>
<%
        Usuarios usuarios = new Usuarios();

        if (usuarios.usuarioAutentificado(usuario)) {
            HttpSession sesion = request.getSession(true);
            sesion.setAttribute("login", usuario.getLogin());

            titulo = "Bienvenido " + usuario.getLogin();

            String urlAnterior = (String) sesion.getAttribute("referer");
            if (urlAnterior == null) {
                urlAnterior = "/";
            } 

            out.println("Redirigiendo a " + urlAnterior + "...");

        
            response.sendRedirect(urlAnterior);

         // Otra forma de hacerlo (pero tendriamos que convertir la url a relativa a lcontexto
        /* %><jsp:forward page="/<%=urlAnterior%>" /><% */

        } else {
            titulo = "Error de autentificacion";

%>
<%--
    Document   : loginValidar
    Created on : 06-may-2009, 10:36:04
    Author     : Administrador
--%>
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