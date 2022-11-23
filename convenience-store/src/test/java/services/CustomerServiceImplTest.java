package services;

import enums.Gender;
import interfaces.CustomerService;
import models.Customer;
import models.Product;
import models.Store;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceImplTest {

    @Test
    void checkingIfBuyProductsReturnsProduct() {
        Store superStore = new Store();
        superStore.readProduct("src/main/resources/products.csv");

        Customer owen = new Customer("Owen", "Mark", 50, "09187654321", Gender.MALE, 10_000.0);
        CustomerService owenPurchase = new CustomerServiceImpl(owen, superStore);

        int owenCartSizeBeforeBuyingProduct = owen.getCart().size();

        Product yam = superStore.getProductsList().get(2);
        Product mayonnaise = superStore.getProductsList().get(3);
        Product omo = superStore.getProductsList().get(5);
        Product shampoo = superStore.getProductsList().get(6);


        owenPurchase.addToCart(shampoo, mayonnaise, mayonnaise, yam, yam, yam, omo);

        int owenCartSizeAfterBuyingProduct = owen.getCart().size();

        assertNotEquals(owenCartSizeBeforeBuyingProduct, owenCartSizeAfterBuyingProduct);
    }
    @Test
    void checkIfBuyProductsReducesCustomersMoney() {
        Store superStore = new Store();
        superStore.readProduct("src/main/resources/products.csv");

        Customer owen = new Customer("Owen", "Mark", 50, "09187654321", Gender.MALE, 10_000.0);
        CustomerService owenPurchase = new CustomerServiceImpl(owen, superStore);

        double walletBalanceBeforeBuying = owen.getPersonalBalance();

        Product yam = superStore.getProductsList().get(2);
        Product mayonnaise = superStore.getProductsList().get(3);
        Product omo = superStore.getProductsList().get(5);
        Product shampoo = superStore.getProductsList().get(6);


        owenPurchase.addToCart(shampoo, mayonnaise, mayonnaise, yam, yam, yam, omo);

        owenPurchase.buyProducts();

        double walletAfterBeforeBuying = owen.getPersonalBalance();

        assertNotEquals(walletBalanceBeforeBuying, walletAfterBeforeBuying);
    }

    @Test
    void checkIfCheckoutAddsCustomerToQueue() {
        Store superStore = new Store();
        superStore.readProduct("src/main/resources/products.csv");

        Customer owen = new Customer("Owen", "Mark", 50, "09187654321", Gender.MALE, 10_000.0);
        CustomerService owenPurchase = new CustomerServiceImpl(owen, superStore);

        int queueSizeBeforeCheckingOut = superStore.getCustomerQueue().size();

        Product yam = superStore.getProductsList().get(2);
        Product mayonnaise = superStore.getProductsList().get(3);
        Product omo = superStore.getProductsList().get(5);
        Product shampoo = superStore.getProductsList().get(6);


        owenPurchase.addToCart(shampoo, mayonnaise, mayonnaise, yam, yam, yam, omo);

        owenPurchase.checkout(owen);

        int queueSizeAfterCheckingOut = superStore.getCustomerQueue().size();

        assertNotEquals(queueSizeAfterCheckingOut, queueSizeBeforeCheckingOut);
    }
}