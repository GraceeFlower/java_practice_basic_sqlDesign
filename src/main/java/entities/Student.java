package entities;

import java.util.Date;

public class Student extends Person {

    public Student() {
    }

    public Student(String color, String name, int age, String gender, String password, Date birthday) {
        super(color, name, age, gender, password, birthday);
    }
}
