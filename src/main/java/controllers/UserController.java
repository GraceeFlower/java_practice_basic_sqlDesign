package controllers;

import repositories.AdminRepository;
import repositories.StudentRepository;
import repositories.TeacherRepository;

public class UserController {

    public boolean isExist(String priority, String usr) {
        boolean isExist;
        switch (Integer.parseInt(priority)) {
            case 1:
                isExist = AdminRepository.getUser(usr.split(":"));
                break;
            case 2:
                isExist = TeacherRepository.getUser(usr.split(":"));
                break;
            default:
                isExist = StudentRepository.getUser(usr.split(":"));
                break;
        }
        return isExist;
    }
}
