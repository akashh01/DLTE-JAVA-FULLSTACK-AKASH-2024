package web;

import employee.implement.entites.Employee;
import employee.implement.implementation.EmployeeDb;
import employee.implement.interfaces.EmployeeInterface;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.sql.SQLException;
import java.util.List;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class EmployeeSoapService {
  //  public EmployeeInterface employeeInterface;

//    @WebMethod
//    public void createEmployee(@WebParam(name="Employee")Employee employee)  {
//       try {
//           employeeInterface.writeEmolyeeToDatabase(employee);
//       }catch (SQLException exp) {
//           System.out.println(exp);
//       }
//}
    @WebMethod
    public void createNewEmployee(@WebParam(name="Employee")Employee employee){
        try {
            EmployeeInterface employeeInterface = new EmployeeDb();
            employeeInterface.writeEmolyeeToDatabase(employee);
        }catch (SQLException exp){
            System.out.println(exp);
        }

    }


   @WebMethod
    @WebResult(name="GroupOfEmployee")
    public GroupOfEmployee readAll(){
       EmployeeInterface employeeInterface=new EmployeeDb();
       GroupOfEmployee list=new GroupOfEmployee();
       List<Employee> myEmp=employeeInterface.getAllEmployee();
       list.setEmployeeList(myEmp);
       return list;
   }



}
