package behavioralpattern.strategypattern.demo01;

/**
 * @author shusheng
 * @description
 * @Email eric_wu_peng@126.com
 * @date 2019/4/20 18:43
 */
//抽象策略接口
interface CarFunction {
    void run();
}
//具体策略父类
class Car implements CarFunction{
    protected String name;
    protected String color;

    public Car(String name, String color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public void run() {
        System.out.println(color +" " + name  +"在行驶。。。");
    }
}
//具体策略实现子类
class SmallCar extends Car {

    public SmallCar(String name, String color) {
        super(name, color);
    }

    public void run() {
        System.out.println(color +" " + name  +"在高速的行驶。。。");
    }

}
//具体策略实现子类
class BussCar extends Car{

    public BussCar(String name, String color) {
        super(name, color);
    }

    public void run() {
        System.out.println(color +" " + name  +"在缓慢的行驶。。。");
    }
}
//应用场景类
class Person {
    private String name;    //姓名
    private Integer age;    //年龄
    private Car car;        //拥有车

    public void driver(Car car){
        System.out.print(name +"  "+ age+" 岁 "+" 开着");
        car.run();
    }

    public Person(String name,Integer age) {
        this.name=name;
        this.age=age;
    }

}
//运行环境类
public class Client {

    public static void main(String[] args) {
        Car smallCar = new SmallCar("路虎","黑色");
        Car bussCar = new BussCar("公交车","白色");
        Person p1 = new Person("小明", 20);
        p1.driver(smallCar);
        p1.driver(bussCar);
    }

}
