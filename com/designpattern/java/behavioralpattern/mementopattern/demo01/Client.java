package behavioralpattern.mementopattern.demo01;

/**
 * @author shusheng
 * @description “白箱”备忘录模式
 * @Email eric_wu_peng@126.com
 * @date 2019/4/22 14:50
 */
//备忘录角色
class Memento {
    private String state;
    public Memento(String state){
        this.state = state;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
}
//发起人角色
class Originator {
    private String state;
    /**工厂方法，返回一个新的备忘录对象*/
    public Memento createMemento(){
        return new Memento(state);
    }
    /**将发起人恢复到备忘录对象所记载的状态*/
    public void restoreMemento(Memento memento){
        this.state = memento.getState();
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
        System.out.println("当前状态：" + this.state);
    }
}
//负责人角色
class Caretaker {
    private Memento memento;
    /**备忘录的取值方法*/
    public Memento retrieveMemento(){
        return this.memento;
    }
    /**备忘录的赋值方法*/
    public void saveMemento(Memento memento){
        this.memento = memento;
    }
}

public class Client {

    public static void main(String[] args) {
        Originator o = new Originator();
        Caretaker c = new Caretaker();
        //改变负责人对象的状态
        o.setState("On");
        //创建备忘录对象，并将发起人对象的状态储存起来
        c.saveMemento(o.createMemento());
        System.out.println("c.memento.state:"+c.retrieveMemento().getState());
        //修改发起人的状态
        o.setState("Off");
        //恢复发起人对象的状态
        o.restoreMemento(c.retrieveMemento());
        System.out.println("c.memento.state:"+c.retrieveMemento().getState());
        System.out.println("o.memento.state:"+o.getState());
    }

}
