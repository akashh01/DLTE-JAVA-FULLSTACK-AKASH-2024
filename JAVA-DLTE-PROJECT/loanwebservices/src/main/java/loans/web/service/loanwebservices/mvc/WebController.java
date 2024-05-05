package loans.web.service.loanwebservices.mvc;

import loan.dao.project.loan.entities.Customer;
import loan.dao.project.loan.entities.LoanAvailable;
import loan.dao.project.loan.interfaces.CustomerInterface;
import loan.dao.project.loan.interfaces.LoanInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/mybank")
public class WebController {
    @Autowired
    LoanInterface loanInterface;

    @Autowired
    CustomerInterface customerInterface;

    @GetMapping("/loanlogin")
    public String landing(){
        return "index";
    }

    @GetMapping("/view")
    public String viewing(){
        return "ViewAll";
    }

    @GetMapping("/dash")
    public String homePage(){
        return "dashboard";
    }

//    @GetMapping("/newloan")
//    public String save(){
//        return "newloan";
//    }


    //@RequestMapping(value="/newloan/{loanNames}",method = RequestMethod.GET)
    @GetMapping("/newloan")
    public String save(@RequestParam String loanNames,Model model){
        List<LoanAvailable> allLoansDao =loanInterface.allAvailableLoan();
        List<LoanAvailable> filteredLoan = allLoansDao.stream()
                .filter(LoanAvailable -> LoanAvailable.getLoanName().equals(loanNames))
                .collect(Collectors.toList());
        model.addAttribute("newAdditionalLoan",filteredLoan.get(0));
        return "newloan";
    }

    @GetMapping("/name")
    @ResponseBody
    public String customerName(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        Customer customer = customerInterface.findByUserName(name);
        return customer.getCustomerName();
    }

    @GetMapping("/error")
    public String errorPage() {
        return "error"; // Return the name of the HTML template for the error page
    }



}
