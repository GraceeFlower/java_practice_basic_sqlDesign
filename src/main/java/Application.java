import controllers.UserController;

import java.util.Scanner;

public class Application {

    public static int type;

    public static void main(String[] args) {
        UserController userController = new UserController();
        Scanner sc = new Scanner(System.in);
        boolean isExist = false;
        do {
            System.out.println("您好，欢迎登陆学生考试系统，请选择您的身份：\n1. 管理员\n2. 老师\n3. 学生");
            String priority = sc.nextLine();
            if (priority.matches("[1-3]")) {
                type = Integer.parseInt(priority);
                System.out.println("请输入您的用户名和密码(用户名:密码)：\n例如：张三:123");
                String usr = sc.nextLine();
                isExist = userController.isExist(priority, usr);
                if (isExist) {
                    System.out.println("登录成功！");
                } else {
                    System.out.println("用户名或密码错误，请重新输入！");
                }
            }
        } while (!isExist);

    }
}