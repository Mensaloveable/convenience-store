package services;

import exceptions.InsufficientFundException;
import exceptions.NotEnoughQuantityException;
import exceptions.OutOfStockException;
import interfaces.CustomerService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import models.Customer;
import models.Product;
import models.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerServiceImpl extends Thread implements CustomerService{
    private Customer customer;
    private Store store;

    @Override
    public void addToCart(Product... products) {
        for (Product product : products) {
            if (product.getQuantity() == 0) {
                try {
                    throw new OutOfStockException("OUT OF STOCK");
                } catch (OutOfStockException outOfStockException) {
//                    outOfStockException.printStackTrace();
                System.out.printf("Sorry dear %s, %s %s%n",customer.getFirstName(), product.getProductName(), outOfStockException.getMessage());
                }
            } else if (product.getQuantity() != 0) {
                customer.setQuantity(customer.getQuantity() + 1);
                customer.setCartPrice(customer.getCartPrice() + product.getProductPrice());
                if (customer.getCart().containsKey(product)) {
                    customer.getCart().replace(product, customer.getCart().get(product) + 1);
                    System.out.println(product.getProductName() + " added to cart" + " (" + customer.getFirstName() + ")");
                    continue;
                }customer.getCart().put(product, 1);
                System.out.println(product.getProductName() + " added to cart" + " (" + customer.getFirstName() + ")");
            }
        }
    }

    @Override
    public  List<Product> buyProducts() {
        List<Product> productsBought = new ArrayList<>();
        try {
            if (customer.getCartPrice() <= customer.getPersonalBalance()) {
                System.out.println(customer.getFirstName() + " buying...");
                for (Map.Entry<Product, Integer> entry : customer.getCart().entrySet()) {
                    if (entry.getKey().getQuantity() >= entry.getValue()) {
                        customer.setPersonalBalance(customer.getPersonalBalance() - (entry.getKey().getProductPrice() * entry.getValue()));
                        entry.getKey().setQuantity(entry.getKey().getQuantity() - entry.getValue());
                        productsBought.add(entry.getKey());
                    } else {
                        throw new NotEnoughQuantityException("Sorry,there is only " + entry.getValue() + " " + entry.getKey().getProductName() + " left");
                    }
                }
            } else {
                throw new InsufficientFundException("Sorry " + customer.getFirstName() + ", you don't have sufficient fund");
            }
        } catch (NotEnoughQuantityException | InsufficientFundException e) {
            System.out.println(e.getMessage());
        }
                return productsBought;
    }

    @Override
    public void run() {
        buyProducts();
    }

    @Override
    public void checkout(Customer customer) {
       store.getCustomerQueue().offer(customer);
    }
}
