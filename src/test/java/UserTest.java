import com.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    private Logger logger = LoggerFactory.getLogger(User.class);

    @Test
    public void userTest() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        // 根据xml标签的 id来获取 bean
        User u = (User) ac.getBean("User");
        u.say();

        // 根据类型来获取 bean
        User user = ac.getBean(User.class);

        // 根据 id 和 类型
        ac.getBean("User", User.class);

        logger.info("success");
    }

}
