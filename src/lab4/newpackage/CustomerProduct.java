/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4.newpackage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author CYBER-TECH
 */
public class CustomerProduct {
    private String customerSSN;
    private String productID;
    private LocalDate purchaseDate;
    private boolean paid;

    
    public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate) {
        this.customerSSN = customerSSN;
        this.productID = productID;
        this.purchaseDate = purchaseDate;
        this.paid = false; // default unpaid
    }

    
    public String getCustomerSSN() {
        return customerSSN;
    }

    
    public String getProductID() {
        return productID;
    }

    
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    
    public String lineRepresentation() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return customerSSN + "," + productID + "," + purchaseDate.format(formatter) + "," + paid;
    }

    
    public boolean isPaid() {
        return paid;
    }

  
    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    
    public String getSearchKey() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return customerSSN + "," + productID + "," + purchaseDate.format(formatter);
    }
}
