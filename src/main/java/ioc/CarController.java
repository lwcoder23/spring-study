package ioc;

import ioc.annotation.Bean;
import ioc.annotation.Di;

@Bean
public class CarController {

    @Di
    CarService carService = new CarServiceImpl();

    public void carController() {
        carService.carAdd();
    }

}
