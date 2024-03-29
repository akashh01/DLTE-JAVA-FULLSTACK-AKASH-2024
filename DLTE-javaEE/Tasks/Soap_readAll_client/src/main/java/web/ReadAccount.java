
package web;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "readAccount", targetNamespace = "http://web/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ReadAccount {


    /**
     * 
     * @param string
     * @return
     *     returns web.AccountDetails
     */
    @WebMethod
    @WebResult(name = "AccountDetails", partName = "AccountDetails")
    @Action(input = "http://web/readAccount/readAllRequest", output = "http://web/readAccount/readAllResponse")
    public AccountDetails readAll(
        @WebParam(name = "String", partName = "String")
        String string);

}
