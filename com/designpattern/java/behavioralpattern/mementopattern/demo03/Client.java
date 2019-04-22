package behavioralpattern.mementopattern.demo03;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shusheng
 * @description 多重检查点
 * @Email eric_wu_peng@126.com
 * @date 2019/4/22 14:50
 */
class Memento {
    private List<String> states;
    private int index;
    /**构造函数*/
    public Memento(List<String> states , int index){
        this.states = new ArrayList<String>(states);
        this.index = index;
    }
    public List<String> getStates() {
        return states;
    }
    public int getIndex() {
        return index;
    }

}
class Originator {
    private List<String> states;
    //检查点索引
    private int index;
    /**构造函数*/
    public Originator(){
        states = new ArrayList<String>();
        index = 0;
    }
    /**工厂方法，返还一个新的备忘录对象*/
    public Memento createMemento(){
        return new Memento(states , index);
    }
    /**将发起人恢复到备忘录对象记录的状态上*/
    public void restoreMemento(Memento memento){
        states = memento.getStates();
        index = memento.getIndex();
    }
    /**状态的赋值方法*/
    public void setState(String state){
        states.add(state);
        index++;
    }
    /**辅助方法，打印所有状态*/
    public void printStates(){
        for(String state : states){
            System.out.println(state);
        }
    }
}

class Caretaker {
    private Originator o;
    private List<Memento> mementos = new ArrayList<Memento>();
    private int current;
    /**构造函数*/
    public Caretaker(Originator o){
        this.o = o;
        current = 0;
    }
    /**创建一个新的检查点*/
    public int createMemento(){
        Memento memento = o.createMemento();
        mementos.add(memento);
        return current++;
    }
    /**将发起人恢复到某个检查点*/
    public void restoreMemento(int index){
        Memento memento = mementos.get(index);
        o.restoreMemento(memento);
    }
    /**将某个检查点删除*/
    public void removeMemento(int index){
        mementos.remove(index);
    }
}

public class Client {

    public static void main(String[] args) {
        Originator o = new Originator();
        Caretaker c = new Caretaker(o);
        //改变状态
        o.setState("state 0");
        //建立一个检查点
        c.createMemento();
        //改变状态
        o.setState("state 1");
        //建立一个检查点
        c.createMemento();
        //改变状态
        o.setState("state 2");
        //建立一个检查点
        c.createMemento();
        //改变状态
        o.setState("state 3");
        //建立一个检查点
        c.createMemento();
        //打印出所有检查点
        o.printStates();
        System.out.println("-----------------恢复检查点-----------------");
        //恢复到第二个检查点
        c.restoreMemento(2);
        //打印出所有检查点
        o.printStates();
    }

}
