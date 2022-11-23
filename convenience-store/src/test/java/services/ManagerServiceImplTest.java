package services;

import enums.Gender;
import enums.Qualification;
import enums.Role;
import interfaces.ManagerService;
import models.Applicant;
import models.Manager;
import models.Store;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerServiceImplTest {

    @Test
    void testingHireCashier() {
        Store superStore = new Store();
        Manager ayo = new Manager("Ayo", "Ola", 60, "09187654321", Gender.FEMALE, Role.MANAGER, Qualification.BSC);
        ManagerService managerAyo = new ManagerServiceImpl();

        Applicant boye =  new Applicant("Boye", "John", 23, Gender.MALE,"09187654321", Qualification.HND);
        Applicant ben =  new Applicant("Ben", "Mosh", 16, Gender.MALE,"09187654321", Qualification.HND);

        assertEquals("Boye John is hired",managerAyo.hireCashier(superStore, boye));
        assertEquals("Ben Mosh doesn't meet criteria", managerAyo.hireCashier(superStore, ben));

    }
}