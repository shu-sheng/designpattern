package behavioralpattern.visitorpattern.demo01.fruit;

import behavioralpattern.visitorpattern.demo01.Visit;

/**
 * 水果接口
 */
public interface Fruit {

    int price();

    int accept(Visit visit);

}
