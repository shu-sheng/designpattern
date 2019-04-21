package behavioralpattern.visitorpattern.demo01;

import behavioralpattern.visitorpattern.demo01.fruit.Apple;
import behavioralpattern.visitorpattern.demo01.fruit.Banana;
import behavioralpattern.visitorpattern.demo01.fruit.Fruit;
import behavioralpattern.visitorpattern.demo01.fruit.Orange;

/**
 * 简单工厂模式 --- 静态工厂模式
 */
public class StaticFactory {
    public static final int TYPE_APPLE = 1;//苹果
    public static final int TYPE_ORANGE = 2;//桔子
    public static final int TYPE_BANANA = 3;//香蕉

    public static Fruit getFruit(int type){
        if(TYPE_APPLE == type){
            return new Apple();
        } else if(TYPE_ORANGE == type){
           return new Orange(80);
        } else if(TYPE_BANANA == type){
            return new Banana();
        }
        return null;
    }

}
