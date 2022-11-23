package models;

import enums.Gender;
import enums.Qualification;

import static org.junit.jupiter.api.Assertions.*;

class ApplicantTest {
    @org.junit.jupiter.api.Test
    void ApplicantApplyForJobTest() {
        Store superStore = new Store();
        Applicant boye =  new Applicant("Boye", "John", 23, Gender.MALE,"09187654321", Qualification.HND);
        Applicant ben =  new Applicant("Ben", "Mosh", 16, Gender.MALE,"09187654321", Qualification.HND);

        assertEquals("Application submitted successfully", boye.applyForJob(superStore));
        assertEquals("Application not accepted, age is below 18", ben.applyForJob(superStore));
    }
}