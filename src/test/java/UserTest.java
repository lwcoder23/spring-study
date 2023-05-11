import lifecycle.Emp;
import com.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class UserTest {

    private Logger logger = LoggerFactory.getLogger(Emp.class);

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

    @Test
    public void testJDBC() throws SQLException {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("jdbc.xml");
        DataSource dataSource = ac.getBean(DataSource.class); /*获取该接口的实现类*/
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void beanLife() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean-life.xml");
        Emp emp = ac.getBean("emp", Emp.class); // 在获取对象时会调用选定的初始化方法
        // 创建对象完成
        // 调用销毁方法
        ac.close();  // 调用的是配置文件中选定的销毁方法

        /*
        *   1. 调用无参构造创建对象
        *   2. property 标签使用set方法为bean对象设置初始参数
        *   3. bean的后置处理器（初始化之前）
        *   4. 调用选定的初始化方法来对bean进行初始化
        *   5. bean的后置处理器（初始化之后）
        *   6. getBean() 使用 bean
        *   7. 调用 选定的销毁方法来销毁 bean
        *   8. IoC关闭
        * */
    }

}
