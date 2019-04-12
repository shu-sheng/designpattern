package creationalpattern.builderpattern.demo1;

import creationalpattern.builderpattern.demo1.fruit.Apple;
import creationalpattern.builderpattern.demo1.fruit.Banana;
import creationalpattern.builderpattern.demo1.fruit.Orange;
/**
 * @author shusheng
 * @description
 * @Email eric_wu_peng@126.com
 * @date 2019/4/12 17:56
 */
public class OldCustomerBuilder implements Builder{
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
        Orange fruit = new Orange(price);
        fruitMeal.setOrange(fruit);
    }

    @Override
    public FruitMeal getFruitMeal() {
        fruitMeal.setDiscount(10);
        fruitMeal.init();
        return fruitMeal;
    }

}
