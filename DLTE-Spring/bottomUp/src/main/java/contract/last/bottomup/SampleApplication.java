package contract.last.bottomup;

import contract.last.bottomup.dto.WSEndpoint;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

public class SampleApplication  implements WebMvcConfigurer {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "users")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema usersSchema) {
        DefaultWsdl11Definition wsdl11Definition = new ReflectionWsdl11Definition();
        wsdl11Definition.setPortTypeName("Users");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace(WSEndpoint.NAMESPACE_URI);
        wsdl11Definition.setSchema(usersSchema);
        wsdl11Definition.setRequestSuffix("Request");
        wsdl11Definition.setResponseSuffix("Response");
        wsdl11Definition.setFaultSuffix("commonFault");
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema usersSchema() {
        return new SimpleXsdSchema(new ClassPathResource("users.xsd"));
    }
}
