package creationalpattern.builderpattern.demo1;

import creationalpattern.builderpattern.demo1.fruit.Apple;
import creationalpattern.builderpattern.demo1.fruit.Banana;
import creationalpattern.builderpattern.demo1.fruit.Orange;

/**
 * @author shusheng
 * @description
 * @Email eric_wu_peng@126.com
 * @date 2019/4/12 17:43
 */
public class FruitMeal {

    private Apple apple;//苹果--价格
    private Banana banana;//香蕉价格
    private Orange orange;    //桔子价格
    private int discount;//折扣价

    private int totalPrice;//套餐总价

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public void setBanana(Banana banana) {
        this.banana = banana;
    }

    public void setOrange(Orange orange) {
        this.orange = orange;
    }

    public void init() {
        if (null != apple){
            totalPrice += apple.getPrice();
        }
        if (null != orange){
            totalPrice += orange.getPrice();
        }
        if (null != banana){
            totalPrice += banana.getPrice();
        }
        if (totalPrice > discount){
            totalPrice -= discount;
        }
    }

    public void cost() {
        System.out.println("totalPrice：" + totalPrice);
    }

}
