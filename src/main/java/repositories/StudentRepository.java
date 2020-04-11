package repositories;

public class StudentRepository {

    public static boolean getUser(String[] usr) {
        return GeneralRepository.getUser(usr, "student");
    }
}
