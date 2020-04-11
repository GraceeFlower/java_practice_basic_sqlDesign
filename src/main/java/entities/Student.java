package entities;

public class Student extends GeneralUser {

    public Student() {
    }

    public Student(int id, String name, int age, char gender, String password) {
        super(id, name, age, gender, password);
    }
}
