package behavioralpattern.visitorpattern.demo01.fruit;

import behavioralpattern.visitorpattern.demo01.Visit;

/**
 * 桔子
 * Created by Peter on 10/9 009.
 */
public class Banana implements Fruit {
    private int price;
    @Override
    public int price() {
        return price;
    }

    public int accept(Visit visit){
        return visit.sell(this);
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
