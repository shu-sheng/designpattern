package creationalpattern.factorymethodpattern;

/**
 * @Description 不使用工厂方法模式，生产一台车.调用者为了组装汽车还需要另外实例化发动机、底盘和轮胎，
 *              而这些汽车的组件是与调用者无关的，严重违反了迪米特法则，耦合度太高。并且非常不利于扩展。
 *              另外，本例中发动机、底盘和轮胎还是比较具体的，
 *              在实际应用中，可能这些产品的组件也都是抽象的，调用者根本不知道怎样组装产品
 * @Author Created by shusheng.
 * @Email shusheng@yiji.com
 * @Date 2017-07-05
 */
class Engine1 {
    public void getStyle(){
        System.out.println("这是汽车的发动机");
    }
}
class Underpan1 {
    public void getStyle(){
        System.out.println("这是汽车的底盘");
    }
}
class Wheel1 {
    public void getStyle(){
        System.out.println("这是汽车的轮胎");
    }
}
class ICar1 {
    public ICar1(Underpan1 engine,Wheel1 underpan,Engine1 wheel) {}
    public static void show(){
        System.out.println("这是我的车");
    }
}

public class Client1 {
    public static void main(String[] args) {
        Engine1 engine = new Engine1();
        Underpan1 underpan = new Underpan1();
        Wheel1 wheel = new Wheel1();
        ICar1 car = new ICar1(underpan, wheel, engine);
        car.show();
    }
}
