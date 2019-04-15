package structuralpattern.bridgepattern.demo01;

/**
 * @Description 未运用桥接模式
 * @Author Created by shusheng.
 * @Email shusheng@yiji.com
 * @Date 2017-07-27
 */
//基类 路
class Road{
    void run() {
        System.out.println("路");
    }
}

//市区街道
class Street extends Road {
    void run() {
        System.out.println("市区街道");
    }
}

//高速公路
class SpeedWay extends Road {
    void run() {
        System.out.println("高速公路");
    }
}

//小汽车在市区街道行驶
class CarOnStreet extends Street {
    void run() {
        System.out.println("小汽车在市区街道行驶");
    }
}
//小汽车在高速公路行驶
class CarOnSpeedWay extends SpeedWay {
    void run() {
        System.out.println("小汽车在高速公路行驶");
    }
}
//公交车在市区街道行驶
class BusOnStreet extends Street {
    void run() {
        System.out.println("公交车在市区街道行驶");
    }
}
//公交车在高速公路行驶
class BusOnSpeedWay extends SpeedWay {
    void run() {
        System.out.println("公交车在高速公路行驶");
    }
}

public class Client {
    public static void main(String[] args) {
        //小汽车在高速公路行驶
        CarOnSpeedWay carOnSpeedWay = new CarOnSpeedWay();
        carOnSpeedWay.run();
        //公交车在市区街道行驶
        BusOnStreet busOnStreet = new BusOnStreet();
        busOnStreet.run();
    }
}