package web;

import javax.xml.ws.Endpoint;

public class EndPoint {
    private static String url="http://localhost:9632/testservice";
    public static void main(String[] args) {
        //CreditCardSoap creditCardSoap=new CreditCardSoap();
        EmployeeSoapService employeeSoapService=new EmployeeSoapService();
        System.out.println("Webservice hosted @ "+url);
        Endpoint.publish(url,employeeSoapService);
    }
}
