<%-- 
    Document   : registrar
    Created on : 07-may-2009, 11:18:50
    Author     : AdminLocal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="nuevoUsuario" class="sesion.Usuario" scope="page">
    <jsp:setProperty name="nuevoUsuario" property="*" />
</jsp:useBean>
<jsp:useBean id="gestor" class="sesion.GestorUsuarios" scope="session"/>


<%@taglib uri="/WEB-INF/tlds/MisTags.tld" prefix="miApp" %>

<%
/*
gestor.añadirUsuario(nuevoUsuario);
gestor.guardarUsuarios();
*/
%>


<miApp:TagNuevoUsuario nuevoUsuario="${nuevoUsuario}" />
    

<jsp:forward page="index.jsp"/>
