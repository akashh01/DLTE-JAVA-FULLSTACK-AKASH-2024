package org.example;

import static org.example.MyBank.loan;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
   // @Test
   // public void shouldAnswerWithTrue()
//    {
//        assertTrue( true );
//    }
   // @BeforeClass
    //public static
    TestLoan testLoan=new TestLoan();
    @BeforeClass
    public static void initalize(){
        loan= Stream.of( new Loan(545454545L,5000L,new Date(2023,05,01),"Open","Akash",9874563214L),
        new Loan(6074899222L,8000L,new Date(2022,06,02),"Close","Harith",9874564444L),
        new Loan(123456987L,9000L,new Date(2022,04,22),"Close","Ajay",7874564444L)).collect(Collectors.toCollection(ArrayList::new));
    }
    public void testavail(){
        assertTrue();
    }

}
