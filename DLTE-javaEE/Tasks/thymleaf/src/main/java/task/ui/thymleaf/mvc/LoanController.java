package task.ui.thymleaf.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoanController {
    @RequestMapping(value = "/loanapply.html",method = RequestMethod.GET)
    public String myTemplate(){
//        model.addAttribute("greet","Welcome to My Bank");
        return "loanapply";
    }
    @RequestMapping(value = "/listall.html",method = RequestMethod.GET)
    public String list(){
//        model.addAttribute("greet","Welcome to My Bank");
        return "listall";
    }


}
