package demo_auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller(value = "user") // <bean id = "user" class = "package.UserController"></bean>  默认值就是首字符小写的类名
public class UserController {

    // 基于xml 配置的自动注入
    /*private UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }*/

    // 在set方法上使用注解自动注入，是基于set方法的注入
    /*private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }*/

    // 在构造方法上加上注解，基于构造方法的自动注入
    /*@Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }*/

    // 在形参上加上注解，基于形式参数的自动注入
    /*public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }*/

    // 基于 Autowired注解(byType)的自动注入
    @Autowired
    private UserService userService;

    public void addUser() {

        /*UserService userService = new UserServiceImpl();
        userService.addUserService();*/

        userService.addUserService();
        System.out.println("add controller");
    }

}
