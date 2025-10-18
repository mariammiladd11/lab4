/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4.newpackage;

/**
 *
 * @author Linae
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class CustomerProductDatabase {
    private ArrayList<CustomerProduct> records;
    private String filename;

    public CustomerProductDatabase(String filename) {
        this.filename = filename;
        this.records = new ArrayList<>();
    }
    public void readFromFile() throws FileNotFoundException {
        records = new ArrayList<>();
        File file = new File(filename);
        Scanner s = new Scanner(file);

        while (s.hasNextLine()) {
            String line = s.nextLine();
            CustomerProduct cp = createRecordFrom(line);
            records.add(cp);
        }
        s.close();
        System.out.println("hi");
    }
    public CustomerProduct createRecordFrom(String line) {
        String[] parts = line.split(",");

        String customerSSN = parts[0];
        String productID = parts[1];

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate purchaseDate = LocalDate.parse(parts[2], formatter);

        boolean paid = Boolean.parseBoolean(parts[3]);

        CustomerProduct cp = new CustomerProduct(customerSSN, productID, purchaseDate);
        cp.setPaid(paid);

        return cp;
    }

    public ArrayList<CustomerProduct> returnAllRecords() {
        return records;
    }

    public boolean contains(String key) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public CustomerProduct getRecord(String key) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getSearchKey().equals(key)) {
                return records.get(i);
            }
        }
        return null;
    }

    public void insertRecord(CustomerProduct record) {
        records.add(record);
    }

    public void deleteRecord(String key) {
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getSearchKey().equals(key)) {
                records.remove(i);
                break;
            }
        }
    }
    public void saveToFile() throws FileNotFoundException {
        PrintWriter out = new PrintWriter(filename);

        for (int i = 0; i < records.size(); i++) {
            out.println(records.get(i).lineRepresentation());
        }

        out.close();
    }
    
}
