package ioc;

import ioc.annotation.Bean;

@Bean
public class Car {

    private String carName;

    private Integer carAge;

    private String carColor;

    public Car() {}

    public Car(String carName, Integer carAge, String carColor) {
        this.carName = carName;
        this.carAge = carAge;
        this.carColor = carColor;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Integer getCarAge() {
        return carAge;
    }

    public void setCarAge(Integer carAge) {
        this.carAge = carAge;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }
}
