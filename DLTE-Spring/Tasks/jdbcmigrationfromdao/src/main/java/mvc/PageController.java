package mvc;

import jdbc.migration.dao.demo.TransactionException;
import jdbc.migration.dao.demo.TransactionService;
import jdbc.migration.dao.demo.Transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PageController {
    @Autowired
    TransactionService transactionService;
    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String showIndexPage(Model model) {
        model.addAttribute("transaction", new Transactions());
        return "index";
    }
    @GetMapping("/")
    public String landing(){
        return "index";
    }
    @RequestMapping(value="/dashboard", method = RequestMethod.GET)
    public String homePage(){
        return "dashboard";
    }
    @RequestMapping(value = "/send",method = RequestMethod.POST)
    public String newTransaction(@ModelAttribute("transaction") Transactions transactionEntity, Model model, RedirectAttributes redirectAttributes) {
        try {
            transactionService.apiInsert(transactionEntity);
            redirectAttributes.addFlashAttribute("message", "Transaction done successfully"+"");
            return "redirect:/web/accept";
        } catch (TransactionException exception) {
            model.addAttribute("error", exception.getMessage());
            return "index";
        }
    }
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String newTransaction(@Valid @ModelAttribute("transaction")  Transactions transaction,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 @RequestParam("transactionDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date transactionDate) {
        if (bindingResult.hasErrors()) {
            return "newTransaction";
        }

        try {
            transaction.setTransactionDate(transactionDate); // Set the parsed date
            transactionService.apiInsert(transaction);
            redirectAttributes.addFlashAttribute("message", "Transaction created successfully");
            return "redirect:/web/confirmation";
        } catch (TransactionException exception) {
            // Handle other exceptions, if any
            redirectAttributes.addFlashAttribute("error", exception.getMessage());
            return "error";
        }
    }


    @GetMapping("/findBySender")
    public String viewTransactionsBySender(@RequestParam("sender") String sender, Model model) {
        try {
            List<Transactions> transactions = transactionService.apiBySender(sender);
            model.addAttribute("transactions", transactions);
            return "viewTransaction"; // Return the name of the Thymeleaf template
        } catch (TransactionException exception) {
            model.addAttribute("error", exception.getMessage());
            return "error";
        }
    }

    @GetMapping("/findByReceiver")
    public String viewTransactionsByReceiver(@RequestParam("receiver") String receiver, Model model) {
        try {
            List<Transactions> transactions = transactionService.apiByRecever(receiver);
            model.addAttribute("transactions", transactions);
            return "viewTransaction";
        } catch (TransactionException exception) {
            model.addAttribute("error", exception.getMessage());
            return "error";
        }
    }

    @GetMapping("/findByAmount")
    public String viewTransactionsByAmount(@RequestParam("amount") Long amount, Model model) {
        try {
            List<Transactions> transactions = transactionService.apiByAmount(amount);
            model.addAttribute("transactions", transactions);
            return "viewTransaction";
        } catch (TransactionException exception) {
            model.addAttribute("error", exception.getMessage());
            return "error";
        }
    }
    @RequestMapping(value = "/error",method = RequestMethod.GET)
    public String handleError(HttpServletRequest request, RedirectAttributes redirectAttributes) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String errorMessage = (String) request.getAttribute("javax.servlet.error.message");

        // Set the status code and message in the model
        redirectAttributes.addFlashAttribute("status", statusCode);
        redirectAttributes.addFlashAttribute("error", errorMessage);

        // Return the error page template
        return "redirect:/web/error";
    }


    @RequestMapping(value = "/accept",method = RequestMethod.GET)
    public String transactionConfirmation(Model model) {
        return "Accepttransaction";
    }
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }
}
