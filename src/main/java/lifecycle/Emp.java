package lifecycle;

public class Emp {

    public Emp() {
        System.out.println("1 调用空参构造方法来创建对象");
    }

    public Emp(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("2 设置属性参数");
        this.name = name;
    }

    public void initMethod() {
        System.out.println("4 bean对象初始化调用指定方法");
    }

    public void destroyMethod() {
        System.out.println("7 调用指定的方法对象销毁");
    }

}
