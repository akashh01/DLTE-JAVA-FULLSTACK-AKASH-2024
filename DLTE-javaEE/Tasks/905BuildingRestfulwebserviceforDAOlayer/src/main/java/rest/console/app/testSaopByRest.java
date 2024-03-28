package rest.console.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/soapcheck/*")
public class testSaopByRest extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("username") != null) {
            String username = req.getParameter("username");
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println(username);
        }
    }
}