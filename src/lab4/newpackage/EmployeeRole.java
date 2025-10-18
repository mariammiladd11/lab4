package lab4.newpackage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sarahkhaled
 */
public class EmployeeRole {
    private ProductDatabase productsDatabase;
    private CustomerProductDatabase customerProductDatabase;

    public EmployeeRole(String productsFile, String customerProductsFile) {
        this.productsDatabase = new ProductDatabase(productsFile);
        this.customerProductDatabase = new CustomerProductDatabase(customerProductsFile);
    }

   
   public void addProduct(String productID, String productName, String manufacturerName, 
                           String supplierName, int quantity, double price) throws FileNotFoundException {
        productsDatabase.readFromFile();

        if (productsDatabase.contains(productID)) {
            System.out.println("Product with ID " + productID + " already exists!");
            return;
        }

        Product newProduct = new Product(productID, productName, manufacturerName, supplierName, quantity, price);
        productsDatabase.insertRecord(newProduct);
        productsDatabase.saveToFile();
    }

    
    public Product[] getListOfProducts() throws FileNotFoundException {
        productsDatabase.readFromFile();
        List<Product> products = productsDatabase.returnAllRecords();
        return products.toArray(new Product[0]);
    }

    
    public CustomerProduct[] getListOfPurchasingOperations() throws FileNotFoundException {
        customerProductDatabase.readFromFile();
        ArrayList<CustomerProduct> purchases = customerProductDatabase.returnAllRecords();
        return purchases.toArray(new CustomerProduct[0]);
    }
   
    public boolean purchaseProduct(String customerSSN, String productID, LocalDate purchaseDate) throws FileNotFoundException {
        productsDatabase.readFromFile();
        customerProductDatabase.readFromFile();

        Product product = productsDatabase.getRecord(productID);

        if (product == null || product.getQuantity() <= 0) {
            return false; 
        }

    
        product.setQuantity(product.getQuantity() - 1);
        CustomerProduct newPurchase = new CustomerProduct(customerSSN, productID, purchaseDate);
        customerProductDatabase.insertRecord(newPurchase);

       
        productsDatabase.saveToFile();
        customerProductDatabase.saveToFile();

        return true;
    }

   
    public double returnProduct(String customerSSN, String productID, LocalDate purchaseDate, LocalDate returnDate) throws FileNotFoundException {
        productsDatabase.readFromFile();
        customerProductDatabase.readFromFile();

        if (returnDate.isBefore(purchaseDate)) return -1;

        Product product = productsDatabase.getRecord(productID);
        if (product == null) return -1;
     String key = customerSSN + "," + productID + "," + purchaseDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        if (!customerProductDatabase.contains(key)) return -1;

        long daysBetween = ChronoUnit.DAYS.between(purchaseDate, returnDate);
        if (daysBetween > 14) return -1;

        
        product.setQuantity(product.getQuantity() + 1);
        customerProductDatabase.deleteRecord(key);

        productsDatabase.saveToFile();
        customerProductDatabase.saveToFile();

        return product.getPrice();
    }

   
    public boolean applyPayment(String customerSSN, LocalDate purchaseDate) throws IOException {
        customerProductDatabase.readFromFile();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for (CustomerProduct cp : customerProductDatabase.returnAllRecords()) {
            String recordKey = cp.getSearchKey();
            String targetKey = customerSSN + "," + cp.getProductID() + "," + purchaseDate.format(formatter);

            if (recordKey.equals(targetKey) && !cp.isPaid()) {
                cp.setPaid(true);
                customerProductDatabase.saveToFile();
                return true;
            }
        }
        return false;
    }
   
    public void logout() throws IOException {
        productsDatabase.saveToFile();
        customerProductDatabase.saveToFile();
}
}