package structuralpattern.adapterpattern.demo03;

/**
 * @Author Created by shusheng.
 * @Email shusheng@yiji.com
 * @Date 2019-04-15
 * @Description 接口适配器（这时我们可以使用一个抽象类作为中间件，即适配器，
 *               用这个抽象类实现接口，而在抽象类中所有的方法都进行置空，那么我们在创建抽象类的继承类，
 *               而且重写我们需要使用的那几个方法）
 */
interface Power {
    void oneStep();
    void twoStep();
    void threeStep();
}

abstract class Adapter implements Power {
    public void oneStep(){};
    public void twoStep(){};
    public void threeStep(){};
}

class XPower extends Adapter{

    public void twoStep(){
        System.out.println("实现两孔能力");
    };
    public void threeStep(){
        System.out.println("实现三孔能力");
    };

}

public class AdapterClient3 {

    public static void main(String[] args) {
        XPower xPower = new XPower();
        xPower.twoStep();
        xPower.threeStep();
    }

}
