package behavioralpattern.visitorpattern.demo01;

/**
 * @author shusheng
 * @description
 * @Email eric_wu_peng@126.com
 * @date 2019/4/21 14:29
 */

import behavioralpattern.visitorpattern.demo01.fruit.Apple;
import behavioralpattern.visitorpattern.demo01.fruit.Fruit;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private static Visit visit = new Visit();
    private static List<Fruit> list = new ArrayList<>();//库存

    static {
        list.add(StaticFactory.getFruit(1));
        list.add(StaticFactory.getFruit(2));
        list.add(StaticFactory.getFruit(3));
    }

    //统计库存商品价值
    private static int price1() {
        int total = 0;
        for (Fruit fruit : list) {
            total += visit.sell(fruit);
        }
        System.out.println("总价值：" + total);
        return total;
    }

    //统计库存商品价值
    private static int price2() {
        int total = 0;
        for (Fruit fruit : list) {
            total += fruit.accept(visit);
        }
        System.out.println("总价值：" + total);
        return total;
    }

    public static void main(String[] args) {
        price2();
    }

    private static void test1() {
        Apple apple = new Apple();
        Fruit fruit = apple;
        //不能识别fruit对象的真实类型
        int price = visit.sell(fruit);
        System.out.println("fruit价格：" + price);
        price = visit.sell(apple);
        System.out.println("apple价格：" + price);
    }

    private static void test2() {
        Apple apple = new Apple();
        Fruit fruit = apple;
        int price = fruit.accept(visit);
        System.out.println("价格：" + price);
    }
}
