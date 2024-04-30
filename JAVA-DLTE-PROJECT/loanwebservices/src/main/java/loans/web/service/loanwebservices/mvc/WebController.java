package loans.web.service.loanwebservices.mvc;

import loan.dao.project.loan.interfaces.LoanInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mybank/")
public class WebController {
    @Autowired
    LoanInterface loanInterface;

    @GetMapping("loanlogin/")
    public String landing(){
        return "index";
    }

    @GetMapping("view/")
    public String viewing(){
        return "ViewAll";
    }
    @RequestMapping(value="/dash", method = RequestMethod.GET)
    public String homePage(){
        return "dashboard";
    }
}
