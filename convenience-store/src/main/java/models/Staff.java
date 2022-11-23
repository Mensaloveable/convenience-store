package models;

import enums.Gender;
import enums.Qualification;
import enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Staff extends Person{
    private static Integer id = 1;
    private Role role;
    private Qualification qualification;

    public Staff() {
        super();
        ++id;
    }

    public Staff(String firstName, String lastName, Integer age, String phoneNumber, Gender gender, Role role, Qualification qualification) {
        super(firstName, lastName, age, phoneNumber,gender);
        this.role = role;
        this.qualification = qualification;
        ++id;
    }


    @Override
    public String toString() {
        return "\nStaff{" + super.toString() +
                "role=" + role +
                ", qualification=" + qualification +
                "}";
    }
}
