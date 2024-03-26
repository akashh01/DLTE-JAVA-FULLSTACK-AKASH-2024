//package org.example;
//
//import employee.implement.implementation.EmployeeDb;
//import employee.implement.entites.Address;
//import employee.implement.entites.Employee;
//import employee.implement.interfaces.EmployeeInterface;
//import org.junit.Test;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.junit.runner.RunWith;
//
//import java.sql.SQLException;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class EmployeetTest {
//
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
//
//}
