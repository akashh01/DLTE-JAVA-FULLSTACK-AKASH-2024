package employee.rest.service.employeerestservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import review.spring.dao.technicalreview.entities.Employee;
import review.spring.dao.technicalreview.exceptions.NoEmployeeData;
import review.spring.dao.technicalreview.interfaces.EmployeeInterface;

import javax.servlet.http.HttpServlet;
import java.util.List;
import java.util.ResourceBundle;


@RestController
@RequestMapping("/Employee/")
@ComponentScan("review.spring.dao.technicalreview")
@CrossOrigin(origins = "*")
public class RestControllers extends HttpServlet {
    ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
    Logger logger= LoggerFactory.getLogger(RestControllers.class);
    @Autowired
    public EmployeeInterface employeeInterface;
//    public
//    @Override
//    public void init() {
//       EmployeeInterface employeeInterfac=new EmployeeDb();
//    }
 @GetMapping("/Details")
 public ResponseEntity<List<Employee>> getAllEmployee(){
     try {
         List<Employee> employeeList = employeeList = employeeInterface.getAllEmployee();
         return new ResponseEntity<>(employeeList, HttpStatus.OK);
     }
     catch (NoEmployeeData emp){
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     }
 }

 @PostMapping("/New")
 public ResponseEntity<Object> writeEmployee(@RequestBody Employee employee){
     try {
         System.out.println(employee);
         String flag=employeeInterface.writeEmolyeeToDatabase(employee);
         if(flag.equals("EXC001")){
             return new ResponseEntity<>(employee, HttpStatus.CREATED);
         }
         else {
             return new ResponseEntity<>(resourceBundle.getString("employee.write.error"), HttpStatus.BAD_REQUEST);

         }

     } catch (Exception e) {
         // Handle exception here
         return new ResponseEntity<>(resourceBundle.getString("emp.sys.err"), HttpStatus.INTERNAL_SERVER_ERROR);
     }
 }

}


//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //try{
//
////        EmployeeInterface employeeInterface=new EmployeeDb();
//
//        resp.setContentType("application/json");
//
//        List<Employee> employeeList= employeeList= employeeInterface.getAllEmployee();
//        Gson gson=new Gson();
//
//        String responseData = gson.toJson(employeeList);
//        resp.getWriter().println(responseData);
//        resp.setStatus(HttpServletResponse.SC_OK);
//
////      }catch (NullPointerException exp){
////        //  resp.setStatus(HttpServletResponse.SC_OK);
////
////          Employee employee=new Employee();
////          Gson gson=new Gson();
////          String responseData = gson.toJson(employee);
////          resp.getWriter().println(responseData);
////      }
//    }}
//


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