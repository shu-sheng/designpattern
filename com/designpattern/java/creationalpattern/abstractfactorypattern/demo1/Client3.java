package creationalpattern.abstractfactorypattern.demo1;

/**
 * @Description 抽象工厂模式
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

class CarA extends Car {
    public CarA(Underpan engine, Wheel underpan, Engine wheel) {}
    public void showCar(){
        System.out.println("这是A型车");
    }
}

class CarB extends Car {
    public CarB(Underpan engine, Wheel underpan, Engine wheel) {}
    public void showCar(){
        System.out.println("这是B型车");
    }
}

abstract class Car{
    public abstract void showCar();
}

class CarCushionA extends CarCushion {

    @Override
    public void showCarCushion() {
        System.out.println("这是A型车用的座垫");
    }
}

class CarCushionB extends CarCushion {

    @Override
    public void showCarCushion() {
        System.out.println("这是B型车用的座垫");
    }
}

abstract class CarCushion{
    public abstract void showCarCushion();
}

interface Factory {
    public Car createCar();
    public CarCushion createCarCushion();
}

class FactoryA implements Factory {
    public Car createCar() {
        Engine engine = new Engine();
        Underpan underpan = new Underpan();
        Wheel wheel = new Wheel();
        Car car = new CarA(underpan, wheel, engine);
        return car;
    }

    @Override
    public CarCushion createCarCushion() {
        CarCushion carCushionA = new CarCushionA();
        return carCushionA;
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

    @Override
    public CarCushion createCarCushion() {
        CarCushion carCushionB = new CarCushionB();
        return carCushionB;
    }
}

public class Client3 {

    public static void main(String[] args) {
        Factory factoryA = new FactoryA();
        factoryA.createCar().showCar();
        factoryA.createCarCushion().showCarCushion();

        Factory factoryB = new FactoryB();
        factoryB.createCar().showCar();
        factoryB.createCarCushion().showCarCushion();
    }

}