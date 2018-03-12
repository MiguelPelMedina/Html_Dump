<%-- 
    Document   : Calculadora
    Created on : 05-mar-2018, 11:01:19
    Author     : Mike
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculadora</title>
    </head>
    <body>
        <%
           
            int op1 = Integer.parseInt(request.getParameter("op1"));
            int op2 = Integer.parseInt(request.getParameter("op2"));
            String oper = request.getParameter("operacion");
            
        %>
        <h1>Resultado:</h1>
        <h2>
            <%=op1%> <%=oper%> <%=op2%> = 
            <% if(oper.equals("+")) { %>
                <%= op1 + op2 %>
            <% }else if(oper.equals("-")){%>
                <%= op1 - op2 %>  
            <% }else if(oper.equals("*")){%>
                <%= op1 * op2 %>
            <% }else if(oper.equals("/")){%>
                <%= op1/op2 %>  
            <%}%>    
        </h2>
    </body>
</html>
