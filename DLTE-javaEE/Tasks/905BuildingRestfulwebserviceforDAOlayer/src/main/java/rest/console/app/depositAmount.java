package rest.console.app;

import application.db.Entities.Customer;
import application.db.Exception.UserNotFoundException;
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
@WebServlet("/deposit/*")
public class depositAmount extends HttpServlet {
    UserInfoServices userInfoServices;
    @Override
    public void init() throws ServletException {

        StorageTarget storageTarget = new DatabaseTarget();
        userInfoServices = new UserInfoServices(storageTarget);
        System.out.println("hello");

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        try{
            String amount = req.getParameter("amount");
            Long amountDeposit = Long.parseLong(amount);
            Gson gson=new Gson();
            Customer customer = gson.fromJson(req.getReader(), Customer.class);
            System.out.println(customer.getUsername()+" "+customer.getInitialBalace());
            userInfoServices.callDepositAmountInto(customer.getUsername(),amountDeposit);
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println("Deposit Updated Successfully");
        }
        catch(NumberFormatException numberFormatException){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().println(numberFormatException);
        }
        catch (UserNotFoundException userNotFoundation){
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            resp.getWriter().println(userNotFoundation);
        }

    }

}
