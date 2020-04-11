package entities;

public class Teacher extends GeneralUser {

    public Teacher() {
    }

    public Teacher(int id, String name, int age, char gender, String password) {
        super(id, name, age, gender, password);
    }
}
