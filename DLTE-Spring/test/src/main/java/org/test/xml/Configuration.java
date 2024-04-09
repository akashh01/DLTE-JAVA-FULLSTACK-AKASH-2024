package org.test.xml;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class Configuration {

    @Bean(name="name1")
   // @Bean
    public Branch myBean2() {
        Branch bean = new Branch();
        bean.setBranchName("Sharjah");
        return bean;
    }
    @Bean(name="name2")
    public Branch myBean() {
        Branch bean = new Branch();
        bean.setBankName("Dubai");
        bean.setBranchId(1215);
        return bean;
    }
}
