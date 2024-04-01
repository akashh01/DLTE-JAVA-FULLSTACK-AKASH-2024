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
import java.sql.SQLException;

@WebServlet("/addEmployee/*")
public class writeEmployeeDetails extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson=new Gson();
        EmployeeInterface employeeInterface=new EmployeeDb();
        Employee employee = gson.fromJson(req.getReader(),Employee.class);
        try {
            employeeInterface.writeEmolyeeToDatabase(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.setStatus(HttpServletResponse.SC_OK);
        resp.getWriter().println(" has added to the records");

    }


}
