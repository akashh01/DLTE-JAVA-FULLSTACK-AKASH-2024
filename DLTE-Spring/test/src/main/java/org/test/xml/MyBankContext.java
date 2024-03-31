package org.test.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBankContext {
    public static void main(String[] args) {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("bank.xml");
        Branch firstBranch=applicationContext.getBean("branch3", Branch.class);
        System.out.println(firstBranch.getIfsCode()+" "+firstBranch.getBranchName());
    }
}
