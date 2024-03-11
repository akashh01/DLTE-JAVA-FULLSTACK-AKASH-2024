package rest;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Create Java EE Rest web service with Servlets which incorporates with Transaction Entity of Java execution and perform following services by considering array list:
//
//        Create Transaction: POST service
//        Read All: GET service
//        Read Transaction which contains amount of given range(min and max) as parameter: GET service
@WebServlet("/transaction/add/*")
public class RestTransactionService extends HttpServlet {
     ArrayList<Transactions> allTransaction= (ArrayList<Transactions>) Stream.of(
             new Transactions(new Date("1/20/2024"),500,"Ajay","Friend"),
             new Transactions(new Date("6/10/2024"),5000,"Deepansh","Family"),
             new Transactions(new Date("7/15/2023"),6500,"Akash","Education"),
             new Transactions(new Date("8/7/2022"),7000,"Current","Bills"),
             new Transactions(new Date("1/20/2024"),50000,"Ajay","Friend")
     ).collect(Collectors.toList());


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //if max and min specified in url gives
        String requestMaxAmount=req.getParameter("Max");
        String requestMinAmount=req.getParameter("Min");
        if(requestMaxAmount!=null&&requestMinAmount!=null){
            int max=Integer.parseInt(requestMaxAmount);
            int min=Integer.parseInt(requestMinAmount);
            Gson gson=new Gson();
            resp.setContentType("application/json");
            for (Transactions each:allTransaction) {
                if(each.getAmountInTransaction()>min&&each.getAmountInTransaction()<max){

                    resp.getWriter().println(gson.toJson(each));
                }
            }
            resp.setStatus(HttpServletResponse.SC_OK);
        }
        else{
            Gson gson=new Gson();
            resp.setContentType("application/json");
            String json = gson.toJson(allTransaction);
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println(json);
        }
    }
    //to post the data object and add it to the arraylist
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson=new Gson();
        Transactions transactions=gson.fromJson(req.getReader(),Transactions.class);
        allTransaction.add(transactions);
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println("to" + transactions.getToWhom()+ "transaction has been done");
    }
}
