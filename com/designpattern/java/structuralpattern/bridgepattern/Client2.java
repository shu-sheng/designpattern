package structuralpattern.bridgepattern;

/**
 * @Description 运用桥接模式
 * @Author Created by shusheng.
 * @Email shusheng@yiji.com
 * @Date 2017-07-31
 */
abstract class AbstractRoad2{
    AbstractCar2 aCar;
    void run(){};
}
abstract class AbstractCar2{
    void run(){};
}

class Street2 extends AbstractRoad2{
    @Override
    void run() {
        super.run();
        aCar.run();
        System.out.println("在市区街道行驶");
    }
}
class SpeedWay2 extends AbstractRoad2{
    @Override
    void run() {
        super.run();
        aCar.run();
        System.out.println("在高速公路行驶");
    }
}
class Car2 extends AbstractCar2{
    @Override
    void run() {
        super.run();
        System.out.print("小汽车");
    }
}
class Bus2 extends AbstractCar2{
    @Override
    void run() {
        super.run();
        System.out.print("公交车");
    }
}

public class Client2 {
    public static void main(String[] args){
        AbstractRoad2 speedWay = new SpeedWay2();
        speedWay.aCar = new Car2();
        speedWay.run();

        AbstractRoad2 street = new Street2();
        street.aCar = new Bus2();
        street.run();
    }
}
