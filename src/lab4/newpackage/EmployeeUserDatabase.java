/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4.newpackage;


import java.util.ArrayList;

/**
 *
 * @author CYBER-TECH
 */
public class EmployeeUserDatabase extends Database<EmployeeUser> {

    private String filename;
  

    public EmployeeUserDatabase(String filename) {   // constructor
        super(filename);
       
    }


    public EmployeeUser createRecordFrom(String line) {   //bey create object el howa new employee 
        String[] parts = line.split(",");
        if (parts.length >= 4) {
            String id = parts[0].trim();
            String name = parts[1].trim();
            String email = parts[2].trim();
            String address = parts[3].trim();
            String phone = parts[3].trim();
            return new EmployeeUser(id, name, email, address, phone);
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



}
