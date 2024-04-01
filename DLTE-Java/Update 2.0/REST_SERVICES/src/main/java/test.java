import employee.implement.entites.Employee;
import employee.implement.implementation.EmployeeDb;
import employee.implement.interfaces.EmployeeInterface;

import java.util.List;

public class test {
    public static void main(String[] args) {
     //   EmployeeInterface employeeInterface;
        EmployeeInterface employeeInterface=new EmployeeDb();
        List<Employee> employeeList=employeeInterface.getAllEmployee();
        System.out.println(employeeList);

    }
}
