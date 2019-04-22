package behavioralpattern.statepattern.demo02;

/**
 * @author shusheng
 * @description 状态模式
 * @Email eric_wu_peng@126.com
 * @date 2019/4/22 19:44
 */
interface DaShengState{
    public void change();
}
class Ordinary implements DaShengState{
    @Override
    public void change() {
        System.out.println("大圣当前为普通状态战斗");
    }
}
class SecondGear implements DaShengState{
    @Override
    public void change() {
        System.out.println("大圣开启三挡战斗");
    }
}
class ThirdGear implements DaShengState{
    @Override
    public void change() {
        System.out.println("大圣开启三挡战斗");
    }
}
class FourthGear implements DaShengState{
    @Override
    public void change() {
        System.out.println("大圣开启四挡战斗");
    }
}

class DaSheng {
    public final static DaShengState ordinary = new Ordinary();//普通状态
    public final static DaShengState secondGear = new SecondGear();//二挡状态
    public final static DaShengState thirdGear = new ThirdGear();//三挡状态
    public final static DaShengState fourthGear = new FourthGear();//四挡状态
    private DaShengState state = ordinary;//一开始是普通状态，初始化state为ORDINARY

    public void setstate(DaShengState state) {
        this.state = state;
    }

    public void change(){
        state.change();
    }
}

public class Client {
    public static void main(String[] args) {
        DaSheng daSheng = new DaSheng();
        daSheng.setstate(daSheng.secondGear);
        daSheng.change();
        daSheng.setstate(daSheng.thirdGear);
        daSheng.change();
        daSheng.setstate(daSheng.fourthGear);
        daSheng.change();
        daSheng.setstate(daSheng.ordinary);
        daSheng.change();
    }
}
