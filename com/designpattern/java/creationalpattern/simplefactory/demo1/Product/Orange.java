package creationalpattern.simplefactory.demo1.Product;

import javax.swing.plaf.synth.SynthSliderUI;

/**
 * @author shusheng
 * @description
 * @Email eric_wu_peng@126.com
 * @date 2019/4/11 14:57
 */
public class Orange extends Fruit{
    @Override
    public void showFruit() {
        System.out.println("我是一个桔子");
    }
}
