package aop.demo;

public class TestProxy {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new CalculateImpl());
        Calculate proxy = (Calculate)proxyFactory.getProxy();
        proxy.add(1, 2);
    }

}
