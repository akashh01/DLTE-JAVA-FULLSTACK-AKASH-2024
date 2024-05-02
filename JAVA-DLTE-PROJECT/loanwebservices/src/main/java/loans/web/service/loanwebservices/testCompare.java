//package loans.web.service.loanwebservices;
//
//import loan.dao.project.loan.entities.Customer;
//import loan.dao.project.loan.services.CustomerAuthServices;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//
//public class testCompare {
//    @Autowired
//    public static CustomerAuthServices services;
//    public String compare(String username){
//        Customer customer=services.findByUserName(username);
//        if(username.equals(customer.getUsername())){
//            System.out.println("correct");
//        }
//        return customer.getUsername();
//
//    }
//
//    public static void main(String[] args) {
//       testCompare testCompare=new testCompare();
//       testCompare.compare("shake123");
//    }
//}
