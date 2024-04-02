//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.03.31 at 08:40:00 PM IST 
//


package services.transactions;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the services.transactions package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: services.transactions
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DeletionResponse }
     * 
     */
    public DeletionResponse createDeletionResponse() {
        return new DeletionResponse();
    }

    /**
     * Create an instance of {@link ServiceStatus }
     * 
     */
    public ServiceStatus createServiceStatus() {
        return new ServiceStatus();
    }

    /**
     * Create an instance of {@link FindBySenderRequest }
     * 
     */
    public FindBySenderRequest createFindBySenderRequest() {
        return new FindBySenderRequest();
    }

    /**
     * Create an instance of {@link NewTransactionRequest }
     * 
     */
    public NewTransactionRequest createNewTransactionRequest() {
        return new NewTransactionRequest();
    }

    /**
     * Create an instance of {@link Transactions }
     * 
     */
    public Transactions createTransactions() {
        return new Transactions();
    }

    /**
     * Create an instance of {@link UpdateRemarkResponse }
     * 
     */
    public UpdateRemarkResponse createUpdateRemarkResponse() {
        return new UpdateRemarkResponse();
    }

    /**
     * Create an instance of {@link FindBySenderResponse }
     * 
     */
    public FindBySenderResponse createFindBySenderResponse() {
        return new FindBySenderResponse();
    }

    /**
     * Create an instance of {@link FindByAmountRequest }
     * 
     */
    public FindByAmountRequest createFindByAmountRequest() {
        return new FindByAmountRequest();
    }

    /**
     * Create an instance of {@link FindByAmountResponse }
     * 
     */
    public FindByAmountResponse createFindByAmountResponse() {
        return new FindByAmountResponse();
    }

    /**
     * Create an instance of {@link NewTransactionResponse }
     * 
     */
    public NewTransactionResponse createNewTransactionResponse() {
        return new NewTransactionResponse();
    }

    /**
     * Create an instance of {@link DeletionRequest }
     * 
     */
    public DeletionRequest createDeletionRequest() {
        return new DeletionRequest();
    }

    /**
     * Create an instance of {@link UpdateRemarksRequest }
     * 
     */
    public UpdateRemarksRequest createUpdateRemarksRequest() {
        return new UpdateRemarksRequest();
    }

    /**
     * Create an instance of {@link FindByRecieverRequest }
     * 
     */
    public FindByRecieverRequest createFindByRecieverRequest() {
        return new FindByRecieverRequest();
    }

    /**
     * Create an instance of {@link FindByRecieverResponse }
     * 
     */
    public FindByRecieverResponse createFindByRecieverResponse() {
        return new FindByRecieverResponse();
    }

}