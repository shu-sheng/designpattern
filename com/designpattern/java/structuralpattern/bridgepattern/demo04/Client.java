package structuralpattern.bridgepattern.demo04;

import java.awt.geom.Area;

/**
 * @author shusheng
 * @description
 * @Email eric_wu_peng@126.com
 * @date 2019/4/15 17:32
 */
interface Qiao{
    void gotoAreaB();
}
class AreaB1 implements Qiao{
    @Override
    public void gotoAreaB() {
        System.out.println("我要去B1");
    }
}
class AreaB2 implements Qiao{
    @Override
    public void gotoAreaB() {
        System.out.println("我要去B2");
    }
}
class AreaB3 implements Qiao{
    @Override
    public void gotoAreaB() {
        System.out.println("我要去B3");
    }
}

abstract class AreaA{
    Qiao qiao;
    abstract void fromA();
}
class AreaA1 extends AreaA{
    @Override
    void fromA() {
        System.out.println("我来自A1");
    }
}
class AreaA2 extends AreaA{
    @Override
    void fromA() {
        System.out.println("我来自A2");
    }
}
class AreaA3 extends AreaA{
    @Override
    void fromA() {
        System.out.println("我来自A3");
    }
}

public class Client {

    public static void main(String[] args) {
        AreaA a1 = new AreaA1();
        a1.qiao = new AreaB1();
        a1.fromA();
        a1.qiao.gotoAreaB();

        AreaA a2 = new AreaA2();
        a2.qiao = new AreaB3();
        a2.fromA();
        a2.qiao.gotoAreaB();
    }

}
