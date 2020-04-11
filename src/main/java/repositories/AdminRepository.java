package repositories;

public class AdminRepository {

    public static boolean getUser(String[] usr) {
        return GeneralRepository.getUser(usr, "administrator");
    }
}
