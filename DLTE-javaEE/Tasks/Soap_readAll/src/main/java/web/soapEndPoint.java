package web;

import javax.xml.ws.Endpoint;
import java.sql.SQLException;

public class soapEndPoint {

    private static String url="http://localhost:1234/assetAvengers";

    public static void main(String[] args) throws SQLException {
        readAccount readAcount=new readAccount();
        System.out.println("Webservice hosted @ "+url);
        Endpoint.publish(url,readAcount);
    }
}
