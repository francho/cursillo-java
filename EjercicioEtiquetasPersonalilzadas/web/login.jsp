<%-- 
    Document   : login
    Created on : 06-may-2009, 12:35:43
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
        <%@include file="WEB-INF/jspf/cabecera.jspf" %>
        <center><form name="login" action="validar" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td><b>Nombre:</b></td>
                        <td><input type="text" name="nombre" value="" size="20" /></td>
                    </tr>
                    <tr>
                        <td><b>Contraseña:</b></td>
                        <td><input type="password" name="password" value="" size="22" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Validar" name="enviar" /></td>
                    </tr>
                </tbody>
            </table>
            </form>
        </center>
    </body>
</html>
