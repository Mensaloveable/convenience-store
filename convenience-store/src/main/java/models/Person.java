package models;

import enums.Gender;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public abstract class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    private String phoneNumber;
    private Gender gender;
}