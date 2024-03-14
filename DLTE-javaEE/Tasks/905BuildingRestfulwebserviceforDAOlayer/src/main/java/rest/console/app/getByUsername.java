package rest.console.app;

import application.db.Entities.Customer;
import application.db.Middlewares.DatabaseTarget;
import application.db.Remotes.StorageTarget;
import application.db.Services.UserInfoServices;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/userdetails/*")
public class getByUsername extends HttpServlet {
    UserInfoServices userInfoServices;
    @Override
    public void init() throws ServletException {

            StorageTarget storageTarget = new DatabaseTarget();
            userInfoServices = new UserInfoServices(storageTarget);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("username") != null) {
            String username=req.getParameter("username");
            Customer customer=new Customer();
            customer=userInfoServices.callOneUserDetails(username);
            //customer = userInfoServices.(String.valueOf(req.getParameter("username")));
            Gson gson=new Gson();
            String details = gson.toJson(customer);
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println(customer.getUsername());
        }
    }
}
