<%-- 
    Document   : salida
    Created on : 05-mar-2018, 9:21:49
    Author     : Mike
--%>

<%@page import="ejemplo1.Formulario"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Date fecha = new Date();
    String name = request.getParameter("nombre");
    String apellidos = request.getParameter("apellidos");
    String edad = Formulario.equivalenciaEdad(request.getParameter("edad"));
    String [] hobbies = request.getParameterValues("hobbies");
    String sex = Formulario.equivalenciaSex(request.getParameter("sexo"));
  %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Servlet que no sé porque no lo veo</title>
    </head>
    <body>
        <h1>Hola,  <%= name %>, <%= apellidos %> </h1>
        tu franja de edad es: <%= edad %><br/>
        tu sexo es : <%= sex %><br/>
        y tus Hobies son :
        <ul>
            <% for ( String l : hobbies) {%>
                <li>
                    <%= Formulario.equivalenciaHobby(l) %>
                </li>
            <% }%>
        </ul>
    </body>
</html>
