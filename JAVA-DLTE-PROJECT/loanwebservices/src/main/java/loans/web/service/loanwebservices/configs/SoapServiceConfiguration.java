package loans.web.service.loanwebservices.configs;


import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import java.util.ResourceBundle;

@EnableWs
@Configuration
public class SoapServiceConfiguration extends WsConfigurerAdapter {
    ResourceBundle resourceBundle = ResourceBundle.getBundle("webservice");
    @Bean
    public ServletRegistrationBean servletRegistrationBean(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setTransformWsdlLocations(true);
        servlet.setApplicationContext(applicationContext);
        return new ServletRegistrationBean(servlet, resourceBundle.getString("servlet.url"));
    }

    // wsdl properties
    @Bean(name = "loans")
    public DefaultWsdl11Definition convertToWsdl(XsdSchema xsdSchema) {
        DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
        defaultWsdl11Definition.setPortTypeName(resourceBundle.getString("port.type"));
        defaultWsdl11Definition.setTargetNamespace(resourceBundle.getString("target.namespace"));
        defaultWsdl11Definition.setLocationUri(resourceBundle.getString("location.uri"));
        defaultWsdl11Definition.setSchema(xsdSchema);
        return defaultWsdl11Definition;
    }


    // identify the xsd
    @Bean
    public XsdSchema loansSchema() {
        return new SimpleXsdSchema(new ClassPathResource("Loan.xsd"));
    }
}
