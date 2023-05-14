package demo_auto;

public class UserController {

    private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser() {

        /*UserService userService = new UserServiceImpl();
        userService.addUserService();*/

        userService.addUserService();
        System.out.println("add controller");
    }

}
