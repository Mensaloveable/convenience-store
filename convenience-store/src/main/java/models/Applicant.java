package models;

import enums.Gender;
import enums.Qualification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Applicant extends Person{
    private Qualification qualification;

    public Applicant(String firstName, String lastName, Integer age, Gender gender, String phoneNumber, Qualification qualification) {
        super(firstName, lastName, age, phoneNumber, gender);
        this.qualification = qualification;
    }

    public String applyForJob(Store store) {
        if (getAge() < 18)
            return "Application not accepted, age is below 18";
        store.getApplicantList().add(new Applicant(getFirstName(), getLastName(), getAge(), getGender(), getPhoneNumber(), getQualification()));
        return "Application submitted successfully";
    }

    @Override
    public String toString() {
        return "\nApplicant{" +
               super.toString() +
                "qualification=" + qualification +
                "}";
    }
}
