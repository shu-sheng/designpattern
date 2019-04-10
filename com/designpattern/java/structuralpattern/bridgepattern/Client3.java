package structuralpattern.bridgepattern;

/**
 * @Description 运用桥接模式，增加一个维度“人”
 * @Author Created by shusheng.
 * @Email shusheng@yiji.com
 * @Date 2017-07-31
 */
abstract class AbstractRoad3{
    AbstractCar3 aCar;
    void run(){};
}
abstract class AbstractCar3{
    void run(){};
}
class Street3 extends AbstractRoad3{
    @Override
    void run() {
        super.run();
        aCar.run();
        System.out.println("在市区街道行驶");
    }
}
class SpeedWay3 extends AbstractRoad3{
    @Override
    void run() {
        super.run();
        aCar.run();
        System.out.println("在高速公路行驶");
    }
}
class Car3 extends AbstractCar3{
    @Override
    void run() {
        super.run();
        System.out.print("小汽车");
    }
}
class Bus3 extends AbstractCar3{
    @Override
    void run() {
        super.run();
        System.out.print("公交车");
    }
}
abstract class People3 {
    AbstractRoad3 road;

    void run() {}
}
class Man3 extends People3{
    @Override
    void run() {
        super.run();
        System.out.print("男人开着");
        road.run();
    }
}
class Woman3 extends People3{
    @Override
    void run() {
        super.run();
        System.out.print("女人开着");
        road.run();
    }
}
public class Client3 {
    public static void main(String[] args) {
        AbstractRoad3 speedWay = new SpeedWay3();
        speedWay.aCar = new Car3();

        People3 man = new Man3();
        man.road = speedWay;
        man.run();
    }
}