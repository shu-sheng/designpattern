package behavioralpattern.visitorpattern.demo01.fruit;

import behavioralpattern.visitorpattern.demo01.Visit;

/**
 * 桔子
 * Created by Peter on 10/9 009.
 */
public class Apple implements Fruit {
    private int price ;

    public Apple(){

    }

    public Apple(int price){
        this.price = price;
    }

    @Override
    public int price() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int accept(Visit visit){
        return visit.sell(this);//指针可以传递真实类型
    }

}
