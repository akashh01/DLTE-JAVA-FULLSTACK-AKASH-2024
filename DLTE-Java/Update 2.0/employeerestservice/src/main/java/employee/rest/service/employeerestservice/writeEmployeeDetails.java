package employee.rest.service.employeerestservice;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import review.spring.dao.technicalreview.entities.Employee;
import review.spring.dao.technicalreview.implementation.EmployeeDb;
import review.spring.dao.technicalreview.interfaces.EmployeeInterface;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@RestController
@RequestMapping("/addEmployee/")
@ComponentScan("review.spring.dao.technicalreview")
public class writeEmployeeDetails extends HttpServlet {
    @Autowired
    public EmployeeInterface employeeInterface;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson=new Gson();
      //  EmployeeInterface employeeInterface=new EmployeeDb();
        Employee employee = gson.fromJson(req.getReader(),Employee.class);
        employeeInterface.writeEmolyeeToDatabase(employee);
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println(" has added to the records");

    }


}