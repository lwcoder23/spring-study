package ioc;

import ioc.annotation.Di;

public class CarServiceImpl implements CarService{

    @Di
    CarDao carDao = new CarDaoImpl();

    public void carAdd() {
        carDao.add();
        System.out.println("car add service");
    }

}
