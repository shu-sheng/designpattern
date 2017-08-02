package adapterpattern;

/**
 * @Description 对象适配器
 * @Author Created by shusheng.
 * @Email shusheng@yiji.com
 * @Date 2017-07-13
 */
interface AmericaPower2 {
    public void threeStep();
}

class APower2 implements AmericaPower2 {
    @Override
    public void threeStep() {
        System.out.println("我是三孔的电源");
    }
}

interface ChinaPower2 {
    public void twoStep();
}

class CPower2 implements ChinaPower2 {
    private AmericaPower2 ap = new APower2();

    @Override
    public void twoStep() {
        ap.threeStep();
    }
}

public class Client2 {
    public static void main(String[] args) {
        ChinaPower2 chinaPower = new CPower2();
        //插入两脚的电源线，可以适配三角的插头。
        chinaPower.twoStep();
    }
}
