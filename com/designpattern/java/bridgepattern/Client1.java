package bridgepattern;

/**
 * @Description 未运用桥接模式
 * @Author Created by shusheng.
 * @Email shusheng@yiji.com
 * @Date 2017-07-27
 */
//基类 路
class Road1{
    void run() {
        System.out.println("路");
    }
}

//市区街道
class Street1 extends Road1 {
    void run() {
        System.out.println("市区街道");
    }
}

//高速公路
class SpeedWay1 extends Road1 {
    void run() {
        System.out.println("高速公路");
    }
}

//小汽车在市区街道行驶
class CarOnStreet1 extends Street1 {
    void run() {
        System.out.println("小汽车在市区街道行驶");
    }
}
//小汽车在高速公路行驶
class CarOnSpeedWay1 extends SpeedWay1 {
    void run() {
        System.out.println("小汽车在高速公路行驶");
    }
}
//公交车在市区街道行驶
class BusOnStreet1 extends Street1 {
    void run() {
        System.out.println("公交车在市区街道行驶");
    }
}
//公交车在高速公路行驶
class BusOnSpeedWay1 extends SpeedWay1 {
    void run() {
        System.out.println("公交车在高速公路行驶");
    }
}

public class Client1 {
    public static void main(String[] args) {
        //小汽车在高速公路行驶
        CarOnSpeedWay1 carOnSpeedWay = new CarOnSpeedWay1();
        carOnSpeedWay.run();
        //公交车在市区街道行驶
        BusOnStreet1 busOnStreet = new BusOnStreet1();
        busOnStreet.run();
    }
}