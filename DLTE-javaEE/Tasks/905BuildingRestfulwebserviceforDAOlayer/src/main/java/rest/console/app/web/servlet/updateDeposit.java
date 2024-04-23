package rest.console.app.web.servlet;

import application.db.Entities.Customer;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/update")
public class updateDeposit extends HttpServlet {
    private StorageTarget storageTarget;
    private UserInfoServices userInfoServices;
    @Override
    public void init() throws ServletException {

            storageTarget = new DatabaseTarget();
        userInfoServices = new UserInfoServices(storageTarget);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String address=req.getParameter("address");
        String email=req.getParameter("email");
        long contact=Long.parseLong(req.getParameter("contact"));
        String amount = req.getParameter("amount");
        Long amountDeposit = Long.parseLong(amount);
        StringBuilder builder = new StringBuilder("Deposit,"+amountDeposit);
        builder.append("," + new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        ArrayList<StringBuilder> transactionOne = new ArrayList<>();
        transactionOne.add(builder);
        Customer customer = new Customer(username,password,address,email,contact,0L,transactionOne);
        RequestDispatcher dispatcher=req.getRequestDispatcher("update.jsp");
        userInfoServices.callDepositAmountInto(customer.getUsername(),amountDeposit);;
        req.setAttribute("info","User Transaction Updated");
        dispatcher.forward(req, resp);
    }
}