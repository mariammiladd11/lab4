/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4.newpackage;

/**
 *
 * @author MALAK
 */
public class Product {
    private String productID;
    private String productName;
    private String manufacturerName;
    private String supplierName;
    private int quantity;
    private double price;

    public Product(String productID, String productName, String manufacturerName,
                   String supplierName, int quantity, double price) {
        this.productID = productID;
        this.productName = productName;
        this.manufacturerName = manufacturerName;
        this.supplierName = supplierName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String lineRepresentation() {
        return productID + "," + productName + "," + manufacturerName + "," +
               supplierName + "," + quantity + "," + price;
    }

    public String getSearchKey() {
        return productID;
    }

    @Override
    public String toString() {
        return "Product ID: " + productID +
               ", Name: " + productName +
               ", Manufacturer: " + manufacturerName +
               ", Supplier: " + supplierName +
               ", Quantity: " + quantity +
               ", Price: " + price;
    }
}
