//package employee.implement;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
//import static org.mockito.Mockito.when;
//
//import employee.implement.entites.Address;
//import employee.implement.entites.Employee;
//import employee.implement.implementation.EmployeeDb;
//import employee.implement.interfaces.EmployeeInterface;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Unit test for simple App.
// */
////
//@RunWith(MockitoJUnitRunner.class)
//public class AppTest {
//    @Mock
//    private EmployeeDb mockEmployeeDb;
//    private EmployeeInterface employeeInterface;
//
//    @Test
//    public void testAdd() throws SQLException {
//        Address address=new Address("SUN","SUNRISE GALI","BANGALORE","KARNATAKA",670006);
//        Employee employeeOne=new Employee("akash","D","h",9874563210L,1257,"akash@gmail.com",address,address);
//        when((mockEmployeeDb.writeEmolyeeToDatabase(employeeOne))).thenReturn("EXC000");
//        String testOut=mockEmployeeDb.writeEmolyeeToDatabase(employeeOne);
//        assertEquals("EXC000",testOut);
//    }
//    @Test
//    public void testFindPincode(){
//        int pincode=670006;
//        Address address=new Address("SUN","SUNRISE GALI","BANGALORE","KARNATAKA",670006);
//        Address addressTwo=new Address("SUN","SUNRISE GALI","BANGALORE","KARNATAKA",670005);
//        Employee employeeOne=new Employee("akash","D","h",9874563210L,1257,"akash@gmail.com",address,address);
//        Employee employeeTwo=new Employee("ajay","D","h",9874563210L,1257,"akash@gmail.com",addressTwo,addressTwo);
//        List<Employee> employeeList = new ArrayList<>();
//        employeeList.add(employeeOne);
//        employeeList.add(employeeTwo);
//        when(mockEmployeeDb.getEmployeeByPin(670006)).thenReturn(employeeList);
//        List<Employee> employeeListTwo = new ArrayList<>();
//        employeeListTwo.add(employeeOne);
//        assertEquals(employeeList.get(0),employeeListTwo.get(0));
//    }
//
//
//
//}
