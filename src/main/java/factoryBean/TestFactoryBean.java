package factoryBean;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestFactoryBean {

    @Test
    public void testFactoryBean() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("factorybean.xml");
        // 通过 FactoryBean类 来获取的 User 对象
        User us = (User) ac.getBean("factorybean");
        us.say();
    }

}
