package behavioralpattern.observerpattern.demo02;

import java.util.Observable;

public class Mango extends Observable {
    private String name;

    public Mango(String name){
        this.name = name;
    }

    //芒果到货了
    public void perform(){
        //标记此 Observable对象为已改变的对象
        this.setChanged();
        //通知所有观察者
        this.notifyObservers();
    }
}
