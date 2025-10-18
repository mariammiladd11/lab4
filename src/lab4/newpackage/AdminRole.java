/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4.newpackage;

/**
 *
 * @author CYBER-TECH
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminRole extends UserRole {
    private EmployeeUserDatabase database;

    public AdminRole() throws IOException {
        super("Admin");
        database = new EmployeeUserDatabase("Employees.txt");
        database.readFromFile();
    }

    
    public void addEmployee(String employeeId, String name, String email, String address, String phoneNumber) throws IOException {
        int phone = Integer.parseInt(phoneNumber);
        EmployeeUser newEmployee = new EmployeeUser(employeeId, name, email, address,phoneNumber);
        database.insertRecord(newEmployee);
        database.writeToFile();
        System.out.println("Employee added successfully: " + name);
    }

 
    public EmployeeUser[] getListOfEmployees() {
        ArrayList<EmployeeUser> list = database.returnAllRecords();
        EmployeeUser[] employees = new EmployeeUser[list.size()];
        for (int i = 0; i < list.size(); i++) {
            employees[i] = list.get(i);
        }
        return employees;
    }

    
    public void removeEmployee(String key) throws IOException {
        if (database.removeRecord(key)) {
            database.writeToFile();
            System.out.println("Employee with ID " + key + " removed successfully.");
        } else {
            System.out.println("No employee found with ID: " + key);
        }
    }

    // Polymorphic override from UserRole
    @Override
    public void logout() {
        try {
            database.writeToFile();
            System.out.println("Admin logged out. All data saved successfully.");
        } catch (IOException ex) {
            
        }
    }
}

