//package contract.last.bottomup.dto;
//
//import org.springframework.context.annotation.Bean;
//
//@Bean
//public SoapFaultMappingExceptionResolver exceptionResolver() throws JAXBException {
//        SoapFaultMappingExceptionResolver exceptionResolver = new SoapFaultExceptionResolver();
//
//        SoapFaultDefinition faultDefinition = new SoapFaultDefinition();
//        faultDefinition.setFaultCode(SoapFaultDefinition.SERVER);
//        exceptionResolver.setDefaultFault(faultDefinition);
//
//        Properties errorMappings = new Properties();
//        errorMappings.setProperty(Exception.class.getName(), SoapFaultDefinition.SERVER.toString());
//        errorMappings.setProperty(ClientException.class.getName(), SoapFaultDefinition.CLIENT.toString());
//        errorMappings.setProperty(DataIntegrityViolationException.class.getName(), SoapFaultDefinition.CLIENT.toString());
//        exceptionResolver.setExceptionMappings(errorMappings);
//        exceptionResolver.setOrder(1);
//        return exceptionResolver;
//        }
