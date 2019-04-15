package structuralpattern.adapterpattern.demo2;

/**
 * @Description 对象适配器（通过组合来实现适配器功能）
 * @Author Created by shusheng.
 * @Email shusheng@yiji.com
 * @Date 2019-04-15
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
        System.out.println("我是美国threeStep");
    }
}

class Adapter implements ChinaPower {

    private AmePower amePower;
    public Adapter(AmePower amePower){
        this.amePower = amePower;
    }
    @Override
    public void twoStep() {
        System.out.println("为twoStep添加threeStep的能力");
        amePower.threeStep();
    }
}

public class AdapterClient2 {

    public static void main(String[] args) {
        ChinaPower chinaPower = new Adapter(new AmePower());
        //插入两脚的电源线，可以适配三角的插头。
        chinaPower.twoStep();
    }

}
