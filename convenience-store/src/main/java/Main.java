import enums.Gender;
import enums.Qualification;
import enums.Role;
import interfaces.ManagerService;
import models.*;
import services.CashierServicesImpl;
import services.CustomerServiceImpl;
import services.ManagerServiceImpl;

public class Main {
    public static void main(String[] args) {
        Store superStore = new Store();
        superStore.readProduct("convenience-store/src/main/resources/products.csv");
        superStore.setAccountBalance(100_000.0d);

        Customer richie = new Customer("Richie", "Oguns", 27, "09187654321", Gender.MALE, 5000.0);
        CustomerServiceImpl richiePurchase = new CustomerServiceImpl(richie, superStore);
        Customer owen = new Customer("Owen", "Mark", 50, "09187654321", Gender.MALE, 10_000.0);
        CustomerServiceImpl owenPurchase = new CustomerServiceImpl(owen, superStore);
        Customer aishah = new Customer("Aishah", "Moshood", 65, "09187654321", Gender.FEMALE, 5000d);
        CustomerServiceImpl aishahPurchase = new CustomerServiceImpl(aishah, superStore);

        Manager ayo = new Manager("Ayo", "Ola", 60, "09187654321", Gender.FEMALE, Role.MANAGER, Qualification.BSC);
        ManagerService managerAyo = new ManagerServiceImpl();

        Cashier austin = new Cashier("Austin", "Okpara", 70, "091987654321", Gender.FEMALE, Role.CASHIER, Qualification.HND);
        CashierServicesImpl cashierAustin = new CashierServicesImpl(superStore);

        Applicant boye =  new Applicant("Boye", "John", 23, Gender.MALE,"09187654321", Qualification.HND);
        Applicant ben =  new Applicant("Ben", "Mosh", 16, Gender.MALE,"09187654321", Qualification.HND);

        System.out.println(boye.applyForJob(superStore));
        System.out.println(ben.applyForJob(superStore));

        System.out.println(managerAyo.hireCashier(superStore, boye));
        System.out.println(managerAyo.hireCashier(superStore, ben));


        Product milk = superStore.getProductsList().get(0);
        Product milo = superStore.getProductsList().get(1);
        Product yam = superStore.getProductsList().get(2);
        Product mayonnaise = superStore.getProductsList().get(3);
        Product sugar = superStore.getProductsList().get(4);
        Product omo = superStore.getProductsList().get(5);
        Product shampoo = superStore.getProductsList().get(6);

        System.out.println("\n********** Adding products to cart **********\n");

        richiePurchase.addToCart(milk, milk, milo, omo);

        owenPurchase.addToCart(shampoo, mayonnaise, mayonnaise, yam, yam, yam, omo);

        aishahPurchase.addToCart(sugar, milk, milo);

        System.out.println("\n********** buying products **********\n");

        richiePurchase.start();
        owenPurchase.start();
        aishahPurchase.start();

        richiePurchase.checkout(richie);
        aishahPurchase.checkout(aishah);
        owenPurchase.checkout(owen);

        System.out.println("#########################################");

        cashierAustin.sellToQueue(superStore.getCustomerQueue());


        System.out.println("\n********** printing receipt **********\n");

        cashierAustin.dispenseReceipt(richie);
    }
}
