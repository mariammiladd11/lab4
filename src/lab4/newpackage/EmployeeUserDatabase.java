/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4.newpackage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author CYBER-TECH
 */
public class EmployeeUserDatabase {
    
   private String filename;
   private ArrayList<EmployeeUser> records;  

    public EmployeeUserDatabase(String filename) {   // constructor
        this.filename = filename;
    }
    
    public void readFromFile() throws FileNotFoundException, IOException {    // bey read el line mn el file we yeb3at el line le create function
        
        FileReader fr = new FileReader(filename);
        Scanner s = new Scanner(fr);
        while (s.hasNextLine()) {
            String line = s.nextLine();
            EmployeeUser employee = createRecordFrom(line);
            if (employee != null) {
                records.add(employee);
            }
        }
        fr.close();
    }
    
    
     public EmployeeUser createRecordFrom(String line) {   //bey create object el howa new employee 
        String[] parts = line.split(",");
        if (parts.length >= 4) {
            String id = parts[0].trim();
            String name = parts[1].trim();               
            String email = parts[2].trim();  
            String address = parts[3].trim();
            int phone = Integer.parseInt(parts[3].trim());
            return new EmployeeUser(id, name, email, address);
        }
        return null;
    }

    
    public ArrayList<EmployeeUser> returnAllRecords() {   
        return records;
    }

    
     public boolean contains(String key) {  
        for (EmployeeUser e : records) {
            if (e.getEmployeeId().equals(key)) {
                return true;
            }
        }
        return false;
    }


    
  public EmployeeUser getRecord(String key) { // return el employee el id beta3o howa howa el key
    for (int i = 0; i < records.size(); i++) {
        EmployeeUser e = records.get(i);
        if (e.getEmployeeId().equals(key)) {
            return e;
        }
    }
    return null;
}

    public void insertRecord(EmployeeUser record) { // law aslan mafish id lel user da a3melo add 
        if (!contains(record.getEmployeeId())) {
            records.add(record);
        }
    }

    public boolean removeRecord(String key) {
        EmployeeUser emp = getRecord(key);
        if (emp != null) {
            records.remove(emp);
            return true;
        }
        return false;
    }

    
    public void writeToFile() throws FileNotFoundException, IOException { 
    FileWriter fw = new FileWriter(filename);

    for (int i = 0; i < records.size(); i++) {
        EmployeeUser e = records.get(i);
        fw.write(e.getEmployeeId() + "," + e.getName() + "," + e.getEmail() + "," + e.getAddress() + "," + e.getEmail()+ "\n");
    }

    fw.close();
}

}
