package ejemplo1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="CabecerasServlet", urlPatterns={"/Cabeceras"})
public class CabecerasServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CabecerasServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cabeceras: </h1>");

            out.println("<ul>");
            Enumeration<String> nombresDeCabeceras = request.getHeaderNames();
            while (nombresDeCabeceras.hasMoreElements()) {
                String cabecera = nombresDeCabeceras.nextElement();
                out.println("<li><b>" + cabecera + ": </b>"
                        + request.getHeader(cabecera) + "</li>");
            }
            
            out.println("</ul>");
            out.println("<br/>");
            out.println("<h1>Otra informaci&oacute;n enviada por request: </h1>");
            out.println("<table>");
            out.println("<tr>");            
            out.println("<td> request.getContextPath():</td>"); 
            out.println("<td>" + request.getContextPath() +  " </td>");             
            out.println("</tr>");                        
            out.println("<tr>");            
            out.println("<td> request.getMethod():</td>"); 
            out.println("<td>" + request.getMethod() +  " </td>");             
            out.println("</tr>");                                    
            out.println("<tr>");            
            out.println("<td> request.getPathInfo():</td>"); 
            out.println("<td>" + request.getPathInfo() +  " </td>");             
            out.println("</tr>");                                                
            out.println("<tr>");            
            out.println("<td> request.getRemoteAddr():</td>"); 
            out.println("<td>" + request.getRemoteAddr() +  " </td>");             
            out.println("</tr>");
            out.println("<tr>");            
            out.println("<td> request.getRemoteHost():</td>"); 
            out.println("<td>" + request.getRemoteHost() +  " </td>");             
            out.println("</tr>");                                                            
            out.println("<tr>");            
            out.println("<td> request.getRemoteUser():</td>"); 
            out.println("<td>" + request.getRemoteUser() +  " </td>");             
            out.println("</tr>");                                                            
            out.println("<tr>");            
            out.println("<td> request.getRequestURI():</td>"); 
            out.println("<td>" + request.getRequestURI() +  " </td>");             
            out.println("</tr>");                     
            out.println("<tr>");            
            out.println("<td> request.getScheme():</td>"); 
            out.println("<td>" + request.getScheme() +  " </td>");             
            out.println("</tr>");                                 
            out.println("<tr>");            
            out.println("<td> request.getServerName():</td>"); 
            out.println("<td>" + request.getServerName() +  " </td>");             
            out.println("</tr>");                                             
            out.println("<tr>");            
            out.println("<td> request.getServletPath():</td>"); 
            out.println("<td>" + request.getServletPath() +  " </td>");             
            out.println("</tr>");                                             
            out.println("<td> request.getLocalPort():</td>"); 
            out.println("<td>" + request.getLocalPort() +  " </td>");             
            out.println("</tr>");             
            out.println("<td> request.getRemotePort():</td>"); 
            out.println("<td>" + request.getRemotePort() +  " </td>");             
            out.println("</tr>");             
            out.println("</table>");            
            out.println("</body>");
            out.println("</html>");

        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
