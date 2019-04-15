package structuralpattern.adapterpattern.demo01;

/**
 * @Description 类适配器（主要使用继承方式来适配）
 * @Author Created by shusheng.
 * @Email shusheng@yiji.com
 * @Date 2017-07-13
 */
interface AmericaPower {
    public void threeStep();
}

interface ChinaPower {
    public void twoStep();
}

class AmePower implements AmericaPower {
    @Override
    public void threeStep() {
        System.out.println("我是threeStep");
    }
}

class Adapter extends AmePower implements ChinaPower {
    @Override
    public void twoStep() {
        System.out.println("为twoStep添加threeStep的能力");
        this.threeStep();
    }
}

public class AdapterClient1 {

    public static void main(String[] args) {
        ChinaPower chinaPower = new Adapter();
        //插入两脚的电源线，可以适配三角的插头。
        chinaPower.twoStep();
    }

}
