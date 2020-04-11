package repositories;

public class TeacherRepository {

    public static boolean getUser(String[] usr) {
        return GeneralRepository.getUser(usr, "teacher");
    }
}
