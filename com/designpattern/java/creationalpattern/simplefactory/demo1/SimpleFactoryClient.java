package creationalpattern.simplefactory.demo1;

import creationalpattern.simplefactory.demo1.Product.Fruit;

/**
 * @author shusheng
 * @description
 * @Email eric_wu_peng@126.com
 * @date 2019/4/11 14:22
 */
public class SimpleFactoryClient {

    public static void main(String[] args) {
        eatApple();
    }

    //Peter自己吃水果
    public static void eatApple(){
        Fruit fruit = SimpleFactory.getFruit(SimpleFactory.TYPE_APPLE);
        fruit.showFruit();

        System.out.println("我拿到了一个苹果");
    }
    
}
