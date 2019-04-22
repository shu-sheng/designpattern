package behavioralpattern.statepattern.demo01;

/**
 * @author shusheng
 * @description 未使用状态模式
 * @Email eric_wu_peng@126.com
 * @date 2019/4/22 19:44
 */
class DaSheng {
    public final static int ORDINARY = 0;//普通状态
    public final static int SECONDGEAR = 1;//二挡状态
    public final static int THIRDGEAR = 2;//三挡状态
    public final static int FOURTHGEAR = 3;//四挡状态
    private int state = ORDINARY;//一开始是普通状态，初始化state为ORDINARY

    public void setstate(int state) {
        this.state = state;
    }

    public void change(){
        if(state == SECONDGEAR){
            System.out.println("大圣开启二挡战斗");
        }else if(state == THIRDGEAR){
            System.out.println("大圣开启三挡战斗");
        }else if(state == FOURTHGEAR){
            System.out.println("大圣开启四挡战斗");
        }else{
            System.out.println("大圣当前为普通状态战斗");
        }
    }
}

public class Client {
    public static void main(String[] args) {
        DaSheng daSheng = new DaSheng();
        daSheng.setstate(daSheng.ORDINARY);
        daSheng.change();
        daSheng.setstate(daSheng.SECONDGEAR);
        daSheng.change();
        daSheng.setstate(daSheng.THIRDGEAR);
        daSheng.change();
        daSheng.setstate(daSheng.FOURTHGEAR);
        daSheng.change();
    }
}
