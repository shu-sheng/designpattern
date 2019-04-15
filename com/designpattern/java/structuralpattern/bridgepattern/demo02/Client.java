package structuralpattern.bridgepattern.demo02;

/**
 * @Description 运用桥接模式
 * @Author Created by shusheng.
 * @Email shusheng@yiji.com
 * @Date 2017-07-31
 */
abstract class AbstractCar{
    void run(){};
}
abstract class AbstractRoad{
    AbstractCar aCar;
    void run(){};
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

public class Client {
    public static void main(String[] args){
        AbstractRoad speedWay = new SpeedWay();
        speedWay.aCar = new Car();
        speedWay.run();
        speedWay.aCar = new Bus();
        speedWay.run();

        AbstractRoad street = new Street();
        street.aCar = new Car();
        street.run();
        street.aCar = new Bus();
        street.run();
    }
}
