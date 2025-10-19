package lab4.newpackage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 *
 * @author sarahkhaled
 */


public class CustomerProductDatabase extends Database<CustomerProduct> {

    public CustomerProductDatabase(String filename) {
        super(filename);
    }

    @Override
    public CustomerProduct createRecordFrom(String line) {
        String[] parts = line.split(",");
        if (parts.length < 3) return null;

        String ssn = parts[0];
        String productId = parts[1];
        LocalDate date = LocalDate.parse(parts[2], DateTimeFormatter.ofPattern("dd-MM-yyyy"));
  CustomerProduct cp = new CustomerProduct(ssn, productId, date);
        if (parts.length > 3)
            cp.setPaid(Boolean.parseBoolean(parts[3]));

        return cp;
    }



}