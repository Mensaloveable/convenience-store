package services;

import enums.Gender;
import enums.Qualification;
import enums.Role;
import interfaces.CashierServices;
import interfaces.CustomerService;
import models.Cashier;
import models.Customer;
import models.Product;
import models.Store;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CashierServicesImplTest {

    @Test
    void checkIfSellMethodAddsSalesAmountToStoreBalance(){
            Store superStore = new Store();
            superStore.readProduct("src/main/resources/products.csv");

            Customer owen = new Customer("Owen", "Mark", 50, "09187654321", Gender.MALE, 10_000.0);
            CustomerService owenPurchase = new CustomerServiceImpl(owen, superStore);

            Product milk = superStore.getProductsList().get(0);
            Product milo = superStore.getProductsList().get(1);
            Product yam = superStore.getProductsList().get(2);
            Product mayonnaise = superStore.getProductsList().get(3);
            Product sugar = superStore.getProductsList().get(4);
            Product omo = superStore.getProductsList().get(5);
            Product shampoo = superStore.getProductsList().get(6);


            owenPurchase.addToCart(shampoo, mayonnaise, mayonnaise, yam, yam, yam, omo);

            owenPurchase.checkout(owen);

            double amountBeforeSelling = superStore.getAccountBalance();

            Cashier austin = new Cashier("Austin", "Okpara", 70, "091987654321", Gender.FEMALE, Role.CASHIER, Qualification.HND);
            CashierServices cashierAustin = new CashierServicesImpl(superStore);

            cashierAustin.sell(owen);

            double amountAfterSelling = superStore.getAccountBalance();

            assertNotEquals(amountAfterSelling, amountBeforeSelling);
    }

    @Test
    void checkingIfDispenseReceiptAddsSalesPriceCorrectly() {
        Store superStore = new Store();
        superStore.readProduct("src/main/resources/products.csv");

        Customer owen = new Customer("Owen", "Mark", 50, "09187654321", Gender.MALE, 10_000.0);
        CustomerService owenPurchase = new CustomerServiceImpl(owen, superStore);

        Product milk = superStore.getProductsList().get(0);
        Product milo = superStore.getProductsList().get(1);
        Product yam = superStore.getProductsList().get(2);
        Product mayonnaise = superStore.getProductsList().get(3);
        Product sugar = superStore.getProductsList().get(4);
        Product omo = superStore.getProductsList().get(5);
        Product shampoo = superStore.getProductsList().get(6);


        owenPurchase.addToCart(shampoo, mayonnaise, mayonnaise, yam, yam, yam, omo);

        owenPurchase.checkout(owen);

        Cashier austin = new Cashier("Austin", "Okpara", 70, "091987654321", Gender.FEMALE, Role.CASHIER, Qualification.HND);
        CashierServices cashierAustin = new CashierServicesImpl(superStore);

        assertEquals(8850.0, cashierAustin.dispenseReceipt(owen));

    }
}