package behavioralpattern.observerpattern.demo01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shusheng
 * @description
 * @Email eric_wu_peng@126.com
 * @date 2019/4/21 14:29
 */
interface Observer {
    void update();
}
class CustomerObserver implements Observer {

    private String name;

    public CustomerObserver(String name){
        this.name = name;
    }
    @Override
    public void update() {
        System.out.println(name + "购买青芒");
    }
}
abstract class Attentions {
    //关注客户列表
    protected List<Observer> observers = new ArrayList();
    //添加关注顾客
    public void add(Observer observer) {
        observers.add(observer);
    }
    //取消关注顾客
    public void remove(Observer observer) {
        observers.remove(observer);
    }
    //发通知
    public abstract void notifyObservers();
}
class MangoAttention extends Attentions{
    @Override
    public void notifyObservers() {
        //遍历观察者集合，调用每一个顾客的购买方法
        for(Observer obs : observers) {
            obs.update();
        }
    }
    //芒果到货了
    public void perform(){
        this.notifyObservers();
    }
}

public class Client {
    public static void main(String[] args) {
        MangoAttention attentions = new MangoAttention();//目标

        attentions.add(new CustomerObserver("deer"));
        attentions.add(new CustomerObserver("james"));
        attentions.add(new CustomerObserver("lison"));
        attentions.add(new CustomerObserver("mark"));

        //到货
        attentions.perform();
    }
}
