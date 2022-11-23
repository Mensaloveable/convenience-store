package services;

import enums.Qualification;
import enums.Role;
import interfaces.ManagerService;
import models.Applicant;
import models.Staff;
import models.Store;

public class ManagerServiceImpl implements ManagerService{
    @Override
    public String hireCashier(Store store, Applicant applicant) {
        if(applicant.getAge() >= 18 && (applicant.getQualification() == Qualification.OND || applicant.getQualification() == Qualification.HND)) {
            store.getStaffList().add(new Staff(applicant.getFirstName(), applicant.getLastName(), applicant.getAge(), applicant.getPhoneNumber(),
                    applicant.getGender(), Role.CASHIER, applicant.getQualification()));
            store.getApplicantList().remove(applicant);
            return applicant.getFirstName() + " " + applicant.getLastName() + " is hired";
        }
        return applicant.getFirstName() + " " + applicant.getLastName() + " doesn't meet criteria";
    }
}
