package loans.web.service.loanwebservices.mvc;

import loan.dao.project.loan.interfaces.LoanInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mybanklogin")
public class WebController {
    @Autowired
    LoanInterface loanInterface;

    @GetMapping("/")
    public String landing(){
        return "index";
    }

}
