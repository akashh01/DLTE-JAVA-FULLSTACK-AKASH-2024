//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.04.14 at 07:01:42 PM IST 
//


package services.loans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for LoanAvailed complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoanAvailed">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="customerNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="loanNumber" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="loanAmount" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="loanEmi" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="loanTenure" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoanAvailed", propOrder = {
    "customerNumber",
    "loanNumber",
    "loanAmount",
    "loanEmi",
    "loanTenure"
})
public class LoanAvailed {

    protected int customerNumber;
    protected long loanNumber;
    protected long loanAmount;
    protected double loanEmi;
    protected int loanTenure;

    /**
     * Gets the value of the customerNumber property.
     * 
     */
    public int getCustomerNumber() {
        return customerNumber;
    }

    /**
     * Sets the value of the customerNumber property.
     * 
     */
    public void setCustomerNumber(int value) {
        this.customerNumber = value;
    }

    /**
     * Gets the value of the loanNumber property.
     * 
     */
    public long getLoanNumber() {
        return loanNumber;
    }

    /**
     * Sets the value of the loanNumber property.
     * 
     */
    public void setLoanNumber(long value) {
        this.loanNumber = value;
    }

    /**
     * Gets the value of the loanAmount property.
     * 
     */
    public long getLoanAmount() {
        return loanAmount;
    }

    /**
     * Sets the value of the loanAmount property.
     * 
     */
    public void setLoanAmount(long value) {
        this.loanAmount = value;
    }

    /**
     * Gets the value of the loanEmi property.
     * 
     */
    public double getLoanEmi() {
        return loanEmi;
    }

    /**
     * Sets the value of the loanEmi property.
     * 
     */
    public void setLoanEmi(double value) {
        this.loanEmi = value;
    }

    /**
     * Gets the value of the loanTenure property.
     * 
     */
    public int getLoanTenure() {
        return loanTenure;
    }

    /**
     * Sets the value of the loanTenure property.
     * 
     */
    public void setLoanTenure(int value) {
        this.loanTenure = value;
    }

}
