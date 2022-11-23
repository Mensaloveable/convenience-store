package interfaces;

import models.Customer;
import models.Product;

import java.util.Collection;
import java.util.List;

public interface CashierServices {
    void sell(Customer customer);

    void sellToQueue(Collection<Customer> customerList);

    Double dispenseReceipt(Customer customer);
}
