package creationalpattern.factorymethodpattern.demo01;

/**
 * @Description 使用工厂方法模式，生产一台车.使用工厂方法后，调用端的耦合度大大降低了。
 *              并且对于工厂来说，是可以扩展的，以后如果想组装其他的汽车，只需要再增加一个工厂类的实现就可以。
 *              无论是灵活性还是稳定性都得到了极大的提高。
 * @Author Created by shusheng.
 * @Email shusheng@yiji.com
 * @Date 2017-07-05
 */
class Engine {
    public Engine(){
        System.out.println("创造一个发动机");
    }
}
class Underpan {
    public Underpan(){
        System.out.println("创造一个底盘");
    }
}
class Wheel {
    public Wheel(){
        System.out.println("创造四个轮子");
    }
}

class CarA extends Car{
    public CarA(Underpan engine,Wheel underpan,Engine wheel) {}
    public void show(){
        System.out.println("这是A型车");
    }
}

class CarB extends Car{
    public CarB(Underpan engine,Wheel underpan,Engine wheel) {}
    public void show(){
        System.out.println("这是B型车");
    }
}

abstract class Car{
    public abstract void show();
}

interface Factory {
    public Car createCar();
}

class FactoryA implements Factory {
    public Car createCar() {
        Engine engine = new Engine();
        Underpan underpan = new Underpan();
        Wheel wheel = new Wheel();
        Car car = new CarA(underpan, wheel, engine);
        return car;
    }
}

class FactoryB implements Factory {
    public Car createCar() {
        Engine engine = new Engine();
        Underpan underpan = new Underpan();
        Wheel wheel = new Wheel();
        Car car = new CarB(underpan, wheel, engine);
        return car;
    }
}

public class Client {

    public static void main(String[] args) {
        Factory factoryA = new FactoryA();
        Car carA = factoryA.createCar();
        carA.show();

        Factory factoryB = new FactoryA();
        Car carB = factoryB.createCar();
        carA.show();
    }

}