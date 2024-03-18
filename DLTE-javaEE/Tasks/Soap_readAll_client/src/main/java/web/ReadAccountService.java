
package web;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "readAccountService", targetNamespace = "http://web/", wsdlLocation = "http://localhost:1234/assetAvengers?wsdl")
public class ReadAccountService
    extends Service
{

    private final static URL READACCOUNTSERVICE_WSDL_LOCATION;
    private final static WebServiceException READACCOUNTSERVICE_EXCEPTION;
    private final static QName READACCOUNTSERVICE_QNAME = new QName("http://web/", "readAccountService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:1234/assetAvengers?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        READACCOUNTSERVICE_WSDL_LOCATION = url;
        READACCOUNTSERVICE_EXCEPTION = e;
    }

    public ReadAccountService() {
        super(__getWsdlLocation(), READACCOUNTSERVICE_QNAME);
    }

    public ReadAccountService(WebServiceFeature... features) {
        super(__getWsdlLocation(), READACCOUNTSERVICE_QNAME, features);
    }

    public ReadAccountService(URL wsdlLocation) {
        super(wsdlLocation, READACCOUNTSERVICE_QNAME);
    }

    public ReadAccountService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, READACCOUNTSERVICE_QNAME, features);
    }

    public ReadAccountService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ReadAccountService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ReadAccount
     */
    @WebEndpoint(name = "readAccountPort")
    public ReadAccount getReadAccountPort() {
        return super.getPort(new QName("http://web/", "readAccountPort"), ReadAccount.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ReadAccount
     */
    @WebEndpoint(name = "readAccountPort")
    public ReadAccount getReadAccountPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://web/", "readAccountPort"), ReadAccount.class, features);
    }

    private static URL __getWsdlLocation() {
        if (READACCOUNTSERVICE_EXCEPTION!= null) {
            throw READACCOUNTSERVICE_EXCEPTION;
        }
        return READACCOUNTSERVICE_WSDL_LOCATION;
    }

}
