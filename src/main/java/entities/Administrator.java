package entities;

public class Administrator extends GeneralUser {

    public Administrator() {
    }

    public Administrator(int id, String name, int age, char gender, String password) {
        super(id, name, age, gender, password);
    }
}
