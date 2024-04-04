package loan.web.services.servicesloan.configs;

import loan.dao.project.loan.entities.LoanAvailable;
import loan.dao.project.loan.interfaces.LoanInterface;
import loan.dao.project.loan.services.LoanServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import services.loans.ServiceStatus;
import services.loans.ViewAllAvailableLoanRequest;
import services.loans.ViewAllAvailableLoanResponse;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ComponentScan("loan.dao.project.loan")
@Endpoint
public class LoanPhase {

    @Autowired
    public  LoanInterface interfaceServices;


    private final String url="http://loans.services";

    @PayloadRoot(namespace = url,localPart = "viewAllAvailableLoanRequest")
    @ResponsePayload
    public ViewAllAvailableLoanResponse viewAvailLoanRequest(@RequestPayload ViewAllAvailableLoanRequest request){
        ViewAllAvailableLoanResponse response=new ViewAllAvailableLoanResponse();
        ServiceStatus serviceStatus=new ServiceStatus();

        List<LoanAvailable> allLoansDao=interfaceServices.allAvailableLoan();

        List<services.loans.LoanAvailable> allLoans=new ArrayList<>();

        Iterator<LoanAvailable> iterator=allLoansDao.iterator();
        while (iterator.hasNext()){
            services.loans.LoanAvailable currentLoan=new services.loans.LoanAvailable();
            BeanUtils.copyProperties(iterator.next(),currentLoan);
            allLoans.add(currentLoan);

        }
            serviceStatus.setStatus("SUCCESS");
            serviceStatus.setMessage("Loan's were fetched");
            response.getLoanAvailable().addAll(allLoans);
            response.setServiceStatus(serviceStatus);

        return response;
    }


}
