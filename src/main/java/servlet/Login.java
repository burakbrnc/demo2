package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import javapart.Kullanici;
import javapart.Erisim;



@WebServlet(name = "Login", urlPatterns = "/login")

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String kullanici=request.getParameter("kullanici");
        String sifre=request.getParameter("sifre");
        Kullanici k=new Erisim().getirKullanici(kullanici,sifre);

        if(k!=null) {
            request.getSession().setAttribute("kullanici", k);
            response.sendRedirect("admin/index.jsp");
            request.getRequestDispatcher("admin/index.jsp").forward(request,response);

        }
        else {
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }


//if(k!=null){
// req.getSession().setAttribute("kullanici", k);
// resp.sendRedirect("admin/index.jsp");
// }
// else{
// req.getRequestDispatcher("/index.jsp").forward(req, resp);
// }
// }




    }






}
