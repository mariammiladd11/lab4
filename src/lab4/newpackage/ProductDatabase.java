package lab4.newpackage;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sarahkhaled
 */
public class ProductDatabase extends Database<Product> {

    public ProductDatabase(String filename) {
        super(filename);
    }

    @Override
    public Product createRecordFrom(String line) {
        System.out.println(line);
        String[] splitProduct = line.split(",");
        String id = splitProduct[0];
        String name = splitProduct[1];
        String manufacturer = splitProduct[2];
        String supplier = splitProduct[3];
        int quantity = Integer.parseInt(splitProduct[4]);
        double price = Double.parseDouble(splitProduct[5]);
        return new Product(id, name, manufacturer, supplier, quantity, price);
    }

    @Override
    public String getKey(Product record) {
        return record.getSearchKey();
    }

    @Override
    public String lineRepresentation(Product record) {
        return record.lineRepresentation();
    }

    @Override
    public String getSearchKey() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void logout() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

