package entities;

import utils.ColumnName;

public class Person extends Feature {

    @ColumnName("username")
    public String name;
    public int age;
    public String gender;
    public String password;

    public Person() {
    }

    public Person(String color, String name, int age, String gender, String password) {
        super(color);
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", gender='" + gender + '\'' +
            ", password='" + password + '\'' +
            '}';
    }
}
