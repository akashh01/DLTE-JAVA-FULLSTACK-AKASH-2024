package rest.console.app.web.servlet;

import application.db.Entities.Customer;
import application.db.Exception.UserNotFoundException;
import application.db.Middlewares.DatabaseTarget;
import application.db.Remotes.StorageTarget;
import application.db.Services.UserInfoServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUsername/*")
public class findByUserName extends HttpServlet {
    private StorageTarget storageTarget;
    private UserInfoServices userInfoServices;
    @Override
    public void init() throws ServletException {
            storageTarget = new DatabaseTarget();
        userInfoServices = new UserInfoServices(storageTarget);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String username = req.getParameter("username");
            Customer customer =userInfoServices.callOneUserDetails(username);
            RequestDispatcher dispatcher = req.getRequestDispatcher("viewByUsername.jsp");
            req.setAttribute("myCards",customer);
            dispatcher.include(req,resp);
        }catch(UserNotFoundException exp){
            resp.getWriter().println(exp);
        }catch (Exception ex){
            System.out.println(ex);
        }
    }
}