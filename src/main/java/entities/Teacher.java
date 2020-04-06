package entities;

public class Teacher extends Person {

    private String course;

    public Teacher() {
    }

    public Teacher(String color, String name, int age, String gender, String password, String course) {
        super(color, name, age, gender, password);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Teacher{" +
            "name='" + name + '\'' +
            ", course='" + course + '\'' +
            ", color='" + color + '\''+
            '}';
    }
}
