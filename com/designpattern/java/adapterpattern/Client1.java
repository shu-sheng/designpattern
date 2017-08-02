package adapterpattern;

/**
 * @Description 类适配器（主要使用继承方式来适配）
 * @Author Created by shusheng.
 * @Email shusheng@yiji.com
 * @Date 2017-07-13
 */
interface AmericaPower1 {
    public void threeStep();
}

class APower1 implements AmericaPower1 {
    @Override
    public void threeStep() {
        System.out.println("我是三角的电源");
    }
}

interface ChinaPower1 {
    public void twoStep();
}

class CPower1 extends APower1 implements ChinaPower1 {
    @Override
    public void twoStep() {
        this.threeStep();
    }
}

public class Client1 {

    public static void main(String[] args) {
        ChinaPower1 chinaPower = new CPower1();
        //插入两脚的电源线，可以适配三角的插头。
        chinaPower.twoStep();
    }

}
