package loans.web.service.loanwebservices.configs;

import loan.dao.project.loan.entities.LoanAvailable;
import loan.dao.project.loan.exceptions.LoanServiceException;
import loan.dao.project.loan.exceptions.NoLoanData;
import loan.dao.project.loan.interfaces.LoanInterface;
import loan.dao.project.loan.services.LoanServices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.TestingAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import services.loans.ServiceStatus;
import services.loans.ViewAllAvailableLoanRequest;
import services.loans.ViewAllAvailableLoanResponse;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@ComponentScan("loan.dao.project.loan")
@Endpoint
public class LoanPhase {
    //autowiring the interface repo from DAO
    @Autowired
    public LoanInterface interfaceServices;
    ResourceBundle resourceBundle = ResourceBundle.getBundle("webservice");
    Logger logger = LoggerFactory.getLogger(LoanServices.class);
    private final String url = "http://loans.services";

    @PayloadRoot(namespace = url, localPart = "viewAllAvailableLoanRequest")
    @ResponsePayload
    public ViewAllAvailableLoanResponse viewAvailLoanRequest(@RequestPayload ViewAllAvailableLoanRequest request) {
        ViewAllAvailableLoanResponse response = new ViewAllAvailableLoanResponse();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        ServiceStatus serviceStatus = new ServiceStatus();
        try {
            List<LoanAvailable> allLoansDao = interfaceServices.allAvailableLoan();
            List<services.loans.LoanAvailable> allLoans = new ArrayList<>();
            //java8
            allLoansDao.forEach(each -> {
                services.loans.LoanAvailable currentLoan = new services.loans.LoanAvailable();
                BeanUtils.copyProperties(each, currentLoan);
                allLoans.add(currentLoan);
            });
            serviceStatus.setStatus(HttpServletResponse.SC_OK);
            response.getLoanAvailable().addAll(allLoans);
            logger.info(resourceBundle.getString("loan.server.available"));
//            if(allLoans==null){
//                serviceStatus.setStatus(HttpServletResponse.SC_OK);
//                serviceStatus.setMessage(resourceBundle.getString("loan.error.four")+ "test");
//            }
        } catch (LoanServiceException exception) {
           // return ResponseEntity.status(HttpServletResponse.SC_OK).body(resourceBundle.getString("loan.error.three")+exception.getMessage());
            serviceStatus.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            serviceStatus.setMessage(resourceBundle.getString("loan.error.four")+ exception.toString());
            logger.info(resourceBundle.getString("loan.server.error"));
        } catch (NoLoanData exception) {
            serviceStatus.setStatus(HttpServletResponse.SC_OK);
            serviceStatus.setMessage(resourceBundle.getString("loan.error.four")+ exception.toString());
            logger.info(resourceBundle.getString("loan.server.error"));
        }
        response.setServiceStatus(serviceStatus);
        return response;
    }


}
