package entities;

import utils.ColumnName;

import java.util.Date;

public class Person extends Feature {

    @ColumnName("username")
    public String name;
    public Date birthday;
    public int age;
    public String gender;
    public String password;

    public Person() {
    }

    public Person(String color, String name, int age, String gender, String password, Date birthday) {
        super(color);
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.password = password;
        this.birthday = birthday;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", birthday=" + birthday +
            ", age=" + age +
            ", gender='" + gender + '\'' +
            ", password='" + password + '\'' +
            ", color='" + color + '\'' +
            '}';
    }
}
