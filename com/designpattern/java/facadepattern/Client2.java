package facadepattern;

/**
 * @Description 外观模式
 * @Author Created by shusheng.
 * @Email shusheng@yiji.com
 * @Date 2017-08-02
 */
class Television {
    public void on() {
        System.out.println("打开了电视....");
    }
    public void off() {
        System.out.println("关闭了电视....");
    }
}

class Light {
    public void on() {
        System.out.println("打开了电灯....");
    }
    public void off() {
        System.out.println("关闭了电灯....");
    }
}

class AirCondition {
    public void on() {
        System.out.println("打开了空调....");
    }
    public void off() {
        System.out.println("关闭了空调....");
    }
}

class Screen {
    public void up() {
        System.out.println("升起银幕....");
    }
    public void down() {
        System.out.println("下降银幕....");
    }
}

class WatchTvSwtichFacade {
    Light light;
    AirCondition ac;
    Television tv;
    Screen screen;

    public WatchTvSwtichFacade(Light light, AirCondition ac, Television tv, Screen screen) {
        this.light = light;
        this.ac = ac;
        this.tv = tv;
        this.screen = screen;
    }

    public void on() {
        light.on();       //首先开灯
        ac.on();          //然后是打开空调
        screen.down();    //把银幕降下来
        tv.on();          //最后是打开电视
    }

    public void off() {
        tv.off();         //首先关闭电视机
        screen.up();      //银幕升上去
        ac.off();         //空调关闭
        light.off();      //最后关灯
    }
}

public class Client2 {
    public static void main(String[] args) {
        //实例化组件
        Light light = new Light();
        Television tv = new Television();
        AirCondition ac = new AirCondition();
        Screen screen = new Screen();

        WatchTvSwtichFacade watchTv = new WatchTvSwtichFacade(light, ac, tv, screen);

        watchTv.on();
        System.out.println("--------------可以看电视了.........");
        watchTv.off();
        System.out.println("--------------可以睡觉了...........");
    }
}
