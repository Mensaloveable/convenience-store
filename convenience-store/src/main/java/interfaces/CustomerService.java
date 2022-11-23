package interfaces;

import models.Customer;
import models.Product;

import java.util.List;

public interface CustomerService {
    void addToCart(Product... products);
    List<Product> buyProducts();

    void checkout(Customer customer);
}
