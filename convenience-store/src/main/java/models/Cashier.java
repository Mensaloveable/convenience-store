package models;

import enums.Gender;
import enums.Qualification;
import enums.Role;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class Cashier extends Staff{
    public Cashier(String firstName, String lastName, Integer age, String phoneNumber, Gender gender, Role role, Qualification qualification) {
        super(firstName, lastName, age, phoneNumber, gender, role, qualification);
    }

    @Override
    public String toString() {
        return "\nCashier{" + super.toString() + '}';
    }
}
