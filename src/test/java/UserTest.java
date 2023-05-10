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
        User u = (User) ac.getBean("User");
        u.say();
        logger.info("success");
    }

}
