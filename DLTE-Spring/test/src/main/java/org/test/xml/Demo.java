package org.test.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {
    //for configuration examples

     public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class);

      //  Branch myBean = context.getBean(Branch.class);//---without name
        Branch myBean = (Branch) context.getBean("name1");
        System.out.println(myBean.getBranchName());
        System.out.println(myBean.getBankName());
    }


}



