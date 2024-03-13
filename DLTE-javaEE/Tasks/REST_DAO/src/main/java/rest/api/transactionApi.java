package rest.api;

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

@WebServlet("/transactions")
public class transactionApi extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //DatabaseTarget databaseTarget=new StorageTarget();

        try {
            StorageTarget  storageTarget = new DatabaseTarget();
           UserInfoServices userInfoServices = new UserInfoServices(storageTarget);
           if(req.getParameter("username")!=null&&req.getParameter("date")!=null){
                 List<List> transactions=new ArrayList<>();
                 transactions=userInfoServices.callTransactionByDate(String.valueOf(req.getParameter("username")),String.valueOf(req.getParameter("date")));
              // System.out.println(transactions.size());
               for(int index=0;index<transactions.size();index++){
                   resp.getWriter().println(transactions.get(index));
               }
               //resp.getWriter().println(String.valueOf(req.getParameter("username"))+String.valueOf(req.getParameter("date")));

           }
           else if(req.getParameter("username")!=null){
               List<List> transactions=new ArrayList<>();
               transactions=userInfoServices.callOneUserTransact(String.valueOf(req.getParameter("username")));
               // System.out.println(transactions.size());
               for(int index=0;index<transactions.size();index++){
                   resp.getWriter().println(transactions.get(index));
               }
           }
           else {
               List<List> transactions=new ArrayList<>();
               transactions=userInfoServices.callFindAll();
               // System.out.println(transactions.size());
               for(int index=0;index<transactions.size();index++){
                   resp.getWriter().println(transactions.get(index));
           }

        }} catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
