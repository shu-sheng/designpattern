package structuralpattern.bridgepattern.demo0;

/**
 * @Description 运用桥接模式，增加一个维度“人”
 * @Author Created by shusheng.
 * @Email shusheng@yiji.com
 * @Date 2017-07-1
 */
abstract class AbstractCar{
    void run(){};
}
abstract class AbstractRoad{
    AbstractCar aCar;
    void run(){};
}
abstract class People {
    AbstractRoad road;
    void run() {}
}

class Street extends AbstractRoad{
    @Override
    void run() {
        super.run();
        aCar.run();
        System.out.println("在市区街道行驶");
    }
}
class SpeedWay extends AbstractRoad{
    @Override
    void run() {
        super.run();
        aCar.run();
        System.out.println("在高速公路行驶");
    }
}
class Car extends AbstractCar{
    @Override
    void run() {
        super.run();
        System.out.print("小汽车");
    }
}
class Bus extends AbstractCar{
    @Override
    void run() {
        super.run();
        System.out.print("公交车");
    }
}

class Man extends People{
    @Override
    void run() {
        super.run();
        System.out.print("男人开着");
        road.run();
    }
}
class Woman extends People{
    @Override
    void run() {
        super.run();
        System.out.print("女人开着");
        road.run();
    }
}
public class Client {
    public static void main(String[] args) {
        People man1 = new Man();
        AbstractRoad speedWay1 = new SpeedWay();
        speedWay1.aCar = new Car();
        man1.road = speedWay1;
        man1.run();

        People man2 = new Man();
        AbstractRoad speedWay2 = new Street();
        speedWay2.aCar = new Bus();
        man2.road = speedWay2;
        man2.run();
    }
}