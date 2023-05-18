package ioc;

import ioc.bean.AnnotationApplicationContext;
import ioc.bean.ApplicationContext;

public class SpringApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationApplicationContext("ioc");
        CarController carController = (CarController)context.getBean(CarController.class);
        carController.carController();
    }

}
