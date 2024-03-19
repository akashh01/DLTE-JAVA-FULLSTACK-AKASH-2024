package web;

import javax.xml.ws.Endpoint;
import java.io.IOException;
import java.sql.SQLException;

public class EndPoint {

    private static String url = "http://localhost:7003/soapservice";
    public static void main(String[] args) throws SQLException, IOException {
        SoapAccount soapAccount = new SoapAccount();
        System.out.println("Web Service Hosted @"+url);
        Endpoint.publish(url,soapAccount);
    }
}