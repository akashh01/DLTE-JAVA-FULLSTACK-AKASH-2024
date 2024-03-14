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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/addAccount/*")
public class createAccountRest extends HttpServlet {
    UserInfoServices userInfoServices;

    @Override
    public void init() throws ServletException {

            StorageTarget storageTarget = new DatabaseTarget();
            userInfoServices = new UserInfoServices(storageTarget);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // resp.setContentType("application/json");
        try {
            Gson gson = new Gson();
            Customer customer = gson.fromJson(req.getReader(), Customer.class);
            userInfoServices.callAddInformation(customer);
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println(customer.toString() + " has added to the records");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        StringBuilder builder = new StringBuilder("Deposit,0");
//        builder.append("," + new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
//        ArrayList<StringBuilder> transactionOne = new ArrayList<>();
//        transactionOne.add(builder);
//        Customer customer2=new Customer("Eeksha", "eeksha123", "Mangalore", "eeksha@gmail", 987455335L, 1000L, transactionOne);
//        resp.getWriter().println(customer2);
//    }
}
