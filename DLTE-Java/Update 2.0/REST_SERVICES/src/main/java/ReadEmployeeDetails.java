import com.google.gson.Gson;
import employee.implement.entites.Employee;
import employee.implement.implementation.EmployeeDb;
import employee.implement.interfaces.EmployeeInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/allemployee/")
public class ReadEmployeeDetails extends HttpServlet {
//    public
//    @Override
//    public void init() {
//        EmployeeInterface employeeInterfac=new EmployeeDb();
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeInterface employeeInterface=new EmployeeDb();
        resp.setContentType("application/json");
        List<Employee> employeeList=employeeInterface.getAllEmployee();
        Gson gson=new Gson();
        String responseData = gson.toJson(employeeList);
        resp.getWriter().println(responseData);
        resp.setStatus(HttpServletResponse.SC_OK);

    }
}



//@WebServlet("/rest/all")
//public class ReadAllService extends HttpServlet {
//    public CreditCardServices creditCardServices;
//
//    @Override
//    public void init() throws ServletException {
//        StorageTarget storageTarget=new DatabaseTarget();
//        creditCardServices=new CreditCardServices(storageTarget);
//    }
//
//    @Override
//    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("application/json");
//        List<CreditCard> creditCards=creditCardServices.callFindAll();
//        Gson gson=new Gson();
//        String responseData = gson.toJson(creditCards);
//        resp.getWriter().println(responseData);
//    }
//}