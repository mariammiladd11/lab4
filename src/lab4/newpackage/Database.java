package lab4.newpackage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author sarahkhaled
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Database<T extends Item> {

    protected ArrayList<T> records;
    protected String filename;

    public Database(String filename) {
        this.filename = filename;
        this.records = new ArrayList<>();
    }

    public abstract T createRecordFrom(String line);

    
    protected String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void readFromFile() throws FileNotFoundException {
        records = new ArrayList<>();
        File file = new File(filename);
        Scanner s = new Scanner(file);

        while (s.hasNextLine()) {
            String line = s.nextLine();
            T record = createRecordFrom(line);
            records.add(record);
        }
        s.close();
    }

    public ArrayList<T> returnAllRecords() {
        return records;
    }

    public boolean contains(String key) {
        for (T record : records) {
            if (record.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public T getRecord(String key) {
        for (T record : records) {
            if (record.getSearchKey().equals(key)) {
                return record;
            }
        }
        return null;
    }

    public void insertRecord(T record) {
        if (contains(record.getSearchKey())) {
            System.out.println("Record with the same key already exists.");
            return;
        }
        records.add(record);
    }

    public void deleteRecord(String key) {
        ArrayList<T> newList = new ArrayList<>();
        boolean found = false;

        for (T record : records) {
            if (!record.getSearchKey().equals(key)) {
                newList.add(record);
            } else {
                found = true;
            }
        }

        records = newList;

        if (found) {
            System.out.println("Record with key " + key + " deleted.");
        } else {
            System.out.println("Record not found.");
        }
    }

    public void saveToFile() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(filename);
        for (T record : records) {
            pw.println(record.lineRepresentation());
        }
        pw.close();
        System.out.println("Records saved successfully to " + filename);
    }
}
