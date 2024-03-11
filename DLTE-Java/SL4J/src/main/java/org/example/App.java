package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ResourceBundle;

/**
 * Hello world!
 *
 */
public class App 
{
    //Logger and LoggerFactory belong to the org.slf4j package
    //sl4j different logging frameworks at deployment time without the need for code changes
    private static Logger logger=LoggerFactory.getLogger(App.class);
    public static void main( String[] args )

    {
        ResourceBundle resourceBundle=ResourceBundle.getBundle("information");
        //System.setProperty("logbackConfiguration","C:\\Users\\xxnlnnpa\\Documents\\DLTE-JAVA-FULLSTACK-AKASH-2024\\DLTE-Java\\SL4J\\src\\main\\resources\\logback.xml");
       Logger logger= LoggerFactory.getLogger(App.class);
        System.out.println("hello");
       logger.info(resourceBundle.getString("check.first"));
       // logger.info("This is a test");
        System.out.println("Lets check the error");
        logger.error(resourceBundle.getString("check.second"));
        System.out.println("Warning");
        //colours are varying
        logger.warn(resourceBundle.getString("check.third"));
        logger.debug("debug testing");
        System.out.println("debug");
    }
}
