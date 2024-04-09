package com.test.bean.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private SingletonBean singletonBean1;

    @Autowired
    private SingletonBean singletonBean2;

    @Autowired
    private PrototypeBean prototypeBean1;

    @Autowired
    private PrototypeBean prototypeBean2;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("SingletonBean1 Count: " + singletonBean1.incrementAndGetCount());
        System.out.println("SingletonBean2 Count: " + singletonBean2.incrementAndGetCount());

        System.out.println("PrototypeBean1 Count: " + prototypeBean1.incrementAndGetCount());
        System.out.println("PrototypeBean2 Count: " + prototypeBean2.incrementAndGetCount());
    }
}

