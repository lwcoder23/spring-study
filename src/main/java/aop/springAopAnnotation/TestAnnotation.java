package aop.springAopAnnotation;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {

    private Logger logger = LoggerFactory.getLogger(TestAnnotation.class);

    @Test
    public void testAnnotation() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("aop-spring.xml");
        Calculate calculate = ac.getBean(Calculate.class);
        Integer sum = calculate.add(1, 2);
        logger.info("执行成功"+sum);
    }

}
