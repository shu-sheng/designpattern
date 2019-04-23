package creationalpattern.builderpattern.demo01;

import creationalpattern.builderpattern.demo01.fruit.Apple;
import creationalpattern.builderpattern.demo01.fruit.Banana;
import creationalpattern.builderpattern.demo01.fruit.Orange;

/**
 * @author shusheng
 * @description
 * @Email eric_wu_peng@126.com
 * @date 2019/4/12 17:53
 */
public class HolidayBuilder implements Builder {
    private FruitMeal fruitMeal = new FruitMeal();

    @Override
    public void buildApple(int price) {
        Apple apple = new Apple();
        apple.setPrice(price);
        fruitMeal.setApple(apple);
    }

    @Override
    public void buildBanana(int price) {
        Banana banana = new Banana();
        banana.setPrice(price);
        fruitMeal.setBanana(banana);
    }

    @Override
    public void buildOrange(int price) {
        Orange orange = new Orange(price);
        fruitMeal.setOrange(orange);
    }

    @Override
    public FruitMeal getFruitMeal() {
        fruitMeal.setDiscount(15);
        fruitMeal.init();
        return fruitMeal;
    }
}
