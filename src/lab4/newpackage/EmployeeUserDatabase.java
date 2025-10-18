/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4.newpackage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author CYBER-TECH
 */
public class EmployeeUserDatabase {
    
   private String filename;
   private ArrayList<EmployeeUser> records;  

    public EmployeeUserDatabase(String filename) {
        this.filename = filename;
    }
    
    public void readFromFile() throws FileNotFoundException {
        
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
    
    
     public EmployeeUser createRecordFrom(String line) {
        String[] parts = line.split(",");
        if (parts.length >= 4) {
            String id = parts[0].trim();
            String name = parts[1].trim();
            String role = parts[2].trim();
            double salary = Double.parseDouble(parts[3].trim());
            return new EmployeeUser(id, name, role, salary);
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


    
   public EmployeeUser getRecord(String key) {
        for (EmployeeUser e : records) {
            if (e.getEmployeeId().equals(key)) {
                return e;
            }
        }
        return null;
    }

    public void insertRecord(EmployeeUser record) {
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

    
    public void writeToFile() throws IOException {
        FileWriter fw = new FileWriter(filename);
        for (EmployeeUser e : records) {
            fw.write(e.toCSV() + "\n");
        }
        fw.close();
    }
}
           
           
    
    
    
    
}
