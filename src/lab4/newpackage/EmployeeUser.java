/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4.newpackage;

import java.time.format.DateTimeFormatter;

/**
 *
 * @author CYBER-TECH
 */
public class EmployeeUser {
     private String employeeID;
    private String Name;
    private String Email;
    private String Address;
    private String phoneNumber;

    public EmployeeUser(String employeeID, String Name, String Email, String Address, String phoneNumber) {
        this.employeeID = employeeID;
        this.Name = Name;
        this.Email = Email;
        this.Address = Address;
        this.phoneNumber = phoneNumber;
    }

    

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

   
    
    public String lineRepresentation(){
        return employeeID+ "," + Name + "," + Email + "," + Address + "," + phoneNumber + ",";
    }
    
    public String getEmployeeId() {
    return employeeID;
}

 public String getSearchKey() {
        
        return employeeID;
    }
   
    
    
    
    
    
}


