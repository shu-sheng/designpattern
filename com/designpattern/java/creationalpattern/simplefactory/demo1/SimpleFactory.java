package creationalpattern.simplefactory.demo1;

import creationalpattern.simplefactory.demo1.Product.Apple;
import creationalpattern.simplefactory.demo1.Product.Banana;
import creationalpattern.simplefactory.demo1.Product.Fruit;
import creationalpattern.simplefactory.demo1.Product.Orange;

/**
 * @author shusheng
 * @description
 * @Email eric_wu_peng@126.com
 * @date 2019/4/11 14:01
 */
public class SimpleFactory {

    public static final int TYPE_APPLE = 1;
    public static final int TYPE_BANANA = 2;
    public static final int TYPE_ORANGE = 3;

    public static Fruit getFruit(int type) {
        if (TYPE_APPLE == type) {
            return new Apple();
        } else if (TYPE_BANANA == type) {
            return new Banana();
        } else if (TYPE_ORANGE == type){
            return new Orange();
        }
        return null;
    }

    /**
     * 多方法工厂
     *
     * @return
     */
    public static Fruit getFruitApple() {
        return new Apple();
    }

    public static Fruit getFruitOrange() {
        return new Orange();
    }

    public static Fruit getFruitBanana() {
        return new Banana();
    }

}
