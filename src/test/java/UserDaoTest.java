import com.UserDao;
import com.UserDaoImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoTest {

    @Test
    public void daoTest() {

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        // 获取只有一个实现类的接口实现类对象
        UserDaoImpl bean = (UserDaoImpl)ac.getBean("userDao");
        // 由接口类型来获取, 要求该接口只有一个实现类
        UserDao acBean = ac.getBean(UserDao.class);
        bean.say();
        acBean.say();
    }

}
