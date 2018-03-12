package ejemplo1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Formulario", urlPatterns={"/Formulario"})
public class Formulario extends HttpServlet {
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String nombre = new String (request.getParameter("nombre").getBytes("ISO-8859-1"),"UTF-8");
        String apellidos = new String (request.getParameter("apellidos").getBytes("ISO-8859-1"),"UTF-8");
        String edad = request.getParameter("edad");
        String[] hobbies = request.getParameterValues("hobbies");
        List jobis = new ArrayList();
        
        request.setAttribute(nombre, edad);
        
        RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/salida.jsp");
        rd.forward(request,response);

       
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

    public static String equivalenciaEdad(String edad) {
        String result = "";
            if(edad.equals("0")){
                result = "menor de 18";
            } else if(edad.equals("1")){
                result = "de 18 a 30";
            } else if(edad.equals("2")){
                result = "menor de 31 a 55";
            }else{
                result = "VIEJO QUE ERE UN VIEO";
                
            }
           return result; 
    }

    public static String equivalenciaHobby(String hobby) {
        String result = "";
        if(hobby.equals("0")){
            result = "lectura";
        }else if(hobby.equals("1")){
            result = "ver la tele";
        }else if(hobby.equals("2")){
            result = "hacer deporte";
        }else{
            result = "música";
        }
        return result;
    }
    public static String equivalenciaSex(String s){
        String result = "";
        if(s != null){
           if(s.equals("H")){
               result = "Hombre";
           }else{
               result = "Mujer";
            }
       }else{
               result= "???";
       }
           return result;
       }

}
