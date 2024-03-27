package xsd.task.transaction.taskxsd.config;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import services.transactions.*;
import xsd.task.transaction.taskxsd.TransactionService;
import xsd.task.transaction.taskxsd.Transactions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Endpoint
public class SoapPhase {
    private final String url="http://transactions.services";
    @Autowired
    private TransactionService transactionService;

    @PayloadRoot(namespace = url,localPart = "newTransactionRequest")
    @ResponsePayload
    public NewTransactionResponse addNewLoan(@RequestPayload NewTransactionRequest newTransactionRequest){
        NewTransactionResponse newTransactionResponse=new NewTransactionResponse();
        ServiceStatus serviceStatus=new ServiceStatus();
        services.transactions.Transactions actual=newTransactionRequest.getTransactions();
        Transactions transactions=new Transactions();
        BeanUtils.copyProperties(actual,transactions);
        transactions=transactionService.apiInsert(transactions);

        if(transactions!=null){
            serviceStatus.setStatus("SUCCESS");
            BeanUtils.copyProperties(transactions,actual);
            newTransactionResponse.setTransactions(actual);
            serviceStatus.setMessage(actual.getTransactionId()+" has inserted");
        }
        else{
            serviceStatus.setStatus("FAILURE");
            serviceStatus.setMessage(actual.getTransactionId()+" hasn't inserted");
        }
        newTransactionResponse.setServiceStatus(serviceStatus);
        return newTransactionResponse;
    }

    @PayloadRoot(namespace = url,localPart = "findBySenderRequest")
    @ResponsePayload
    public FindBySenderResponse findBySenderRequest(@RequestPayload FindBySenderRequest findBySenderRequest){
        FindBySenderResponse findBySenderResponse=new FindBySenderResponse();
        ServiceStatus serviceStatus=new ServiceStatus();
        List<services.transactions.Transactions> transactList=new ArrayList<>();
        List<Transactions> transatListTwo=transactionService.apiBySender(findBySenderRequest.getSenderName());

        Iterator<Transactions> iterator=transatListTwo.iterator();
        while (iterator.hasNext()){
            services.transactions.Transactions currentTransactions=new services.transactions.Transactions();
            BeanUtils.copyProperties(iterator.next(),currentTransactions);
            transactList.add(currentTransactions);
        }

        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Transactions available");
        findBySenderResponse.setServiceStatus(serviceStatus);
       findBySenderResponse.getTransactions().addAll(transactList);
        return findBySenderResponse;
    }
    @PayloadRoot(namespace = url,localPart = "findByAmountRequest")
    @ResponsePayload
    public FindByAmountResponse findByAmountRequest(@RequestPayload FindByAmountRequest findByAmountRequest){
        FindByAmountResponse findByAmountResponse=new FindByAmountResponse();
        ServiceStatus serviceStatus=new ServiceStatus();
        List<services.transactions.Transactions> transactList=new ArrayList<>();
        List<Transactions> transatListTwo=transactionService.apiBySender(findByAmountRequest.getRecieverName());

        Iterator<Transactions> iterator=transatListTwo.iterator();
        while (iterator.hasNext()){
            services.transactions.Transactions currentTransactions=new services.transactions.Transactions();
            BeanUtils.copyProperties(iterator.next(),currentTransactions);
            transactList.add(currentTransactions);
        }

        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Transactions available");
        findByAmountResponse.setServiceStatus(serviceStatus);
        findByAmountResponse.getTransactions().addAll(transactList);
        return findByAmountResponse;
    }

    @PayloadRoot(namespace = url,localPart = "findByRecieverRequest")
    @ResponsePayload
    public FindByRecieverResponse findByRecieverRequest(@RequestPayload FindByRecieverRequest findByRecieverRequest){
        FindByRecieverResponse findByRecieverResponse=new FindByRecieverResponse();
        ServiceStatus serviceStatus=new ServiceStatus();
        List<services.transactions.Transactions> transactList=new ArrayList<>();
        List<Transactions> transatListTwo=transactionService.apiBySender(findByRecieverRequest.getRecieverName());

        Iterator<Transactions> iterator=transatListTwo.iterator();
        while (iterator.hasNext()){
            services.transactions.Transactions currentTransactions=new services.transactions.Transactions();
            BeanUtils.copyProperties(iterator.next(),currentTransactions);
            transactList.add(currentTransactions);
        }

        serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage("Transactions available");
        findByRecieverResponse.setServiceStatus(serviceStatus);
        findByRecieverResponse.getTransactions().addAll(transactList);
        return findByRecieverResponse;
    }


      @PayloadRoot(namespace = url, localPart = "updateRemarksRequest")
      @ResponsePayload
      public UpdateRemarkResponse updatingTransaction(@RequestPayload UpdateRemarksRequest updateRemarksRequest){
        UpdateRemarkResponse updateRemarksResponse=new UpdateRemarkResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        services.transactions.Transactions transactions=new services.transactions.Transactions();
          xsd.task.transaction.taskxsd.Transactions daoTransaction = new xsd.task.transaction.taskxsd.Transactions();
        BeanUtils.copyProperties(updateRemarksRequest.getTransactions(),daoTransaction);
        daoTransaction = transactionService.updateLoans(daoTransaction);
        if (daoTransaction!=null){
            serviceStatus.setStatus("SUCCESS");
            serviceStatus.setMessage(daoTransaction.getTransactionId()+" has been updated");
        }else {
            serviceStatus.setStatus("FAILURE");
            serviceStatus.setMessage(daoTransaction.getTransactionId()+" hasn't been updated");
        }
        BeanUtils.copyProperties(daoTransaction,transactions);

        updateRemarksResponse.setServiceStatus(serviceStatus);
        updateRemarksResponse.setTransactions(transactions);

        return updateRemarksResponse;
    }
    @PayloadRoot(namespace = url,localPart = "DeletionRequest")
    @ResponsePayload
    public DeletionResponse deletionByCall(@RequestPayload DeletionRequest deletionRequest){
        DeletionResponse deletionResponse=new DeletionResponse();
        ServiceStatus serviceStatus=new ServiceStatus();
        String message = transactionService.removeTransaction(deletionRequest.getStartDate(),deletionRequest.getEndDate());
        if(message.contains("Invalid"))
            serviceStatus.setStatus("FAILURE");
        else
            serviceStatus.setStatus("SUCCESS");
        serviceStatus.setMessage(message);
        deletionResponse.setServiceStatus(serviceStatus);
        return deletionResponse;
    }




}
