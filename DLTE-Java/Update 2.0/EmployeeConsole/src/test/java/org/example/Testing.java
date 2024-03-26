//package org.example;
//
//import static org.junit.Assert.assertTrue;
//import static org.mockito.Mockito.when;
//
//import employee.implement.entites.Address;
//import employee.implement.entites.Employee;
//import org.example.validation.BasicValidation;
//import org.example.validation.ReValidation;
//import org.junit.Test;
//
///**
// * Unit test for simple App.
// */
//public class Testing
//{
//    BasicValidation validation=new BasicValidation();
//    @org.junit.Test
//    public void testEmailId(){
//        String email="afsd#gmail.com";
//        assertTrue(validation.validateEmail(email));
//    }
//    @org.junit.Test
//    public void testPhone(){
//        Long phone=985632140L;
//        assertTrue(validation.validatePhone(phone));
//    }
//    @org.junit.Test
//    public void testPincode(){
//        int pinCode=987412;
//        assertTrue(validation.validatePincode(pinCode));
//    }
//
//    ReValidation reValidation=new ReValidation();
//    @org.junit.Test
//    public void testRevalidation(){
//        Address address=new Address("SUN","SUNRISE GALI","BANGALORE","KARNATAKA",670006);
//        Employee employeeOne=new Employee("akash","D","h",9874563210L,1257,"akash@gmail.com",address,address);
//        reValidation.reValidate("name",employeeOne);
//        //when(reValidation.reValidate("email",employeeOne)).then("akash@gmail.com");
//    }
//
//
//
//}
