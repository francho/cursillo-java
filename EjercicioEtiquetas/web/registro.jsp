<%-- 
    Document   : registro
    Created on : 07-may-2009, 11:13:14
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
        <center>
            <form name="registro" action="registrar.jsp" method="POST">
                <table border="1">
                    <tbody>
                        <tr>
                            <td>Identificador:</td>
                            <td><input type="text" name="identificador" value="" /></td>
                        </tr>
                        <tr>
                            <td>Nombre Completo:</td>
                            <td><input type="text" name="nombreCompleto" value="" /></td>
                        </tr>
                        <tr>
                            <td>Contraseña:</td>
                            <td><input type="password" name="password" value="" /></td>
                        </tr>
                    </tbody>
                </table>
                <input type="submit" value="Registrar" name="registrar" />
            </form>
        </center>
    </body>
</html>
