package behavioralpattern.mementopattern.demo02;

/**
 * @author shusheng
 * @description “黑箱”备忘录模式
 * @Email eric_wu_peng@126.com
 * @date 2019/4/22 14:50
 */
interface MementoIF {
}
//发起人角色
class Originator {
    private String state;
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
        System.out.println("赋值状态：" + state);
    }
    /**
     * 工厂方法，返还一个新的备忘录对象
     */
    public MementoIF createMemento(){
        return new Memento(state);
    }
    /**
     * 发起人恢复到备忘录对象记录的状态
     */
    public void restoreMemento(MementoIF memento){
        this.setState(((Memento)memento).getState());
    }
    //备忘录角色
    private class Memento implements MementoIF{
        private String state;
        private Memento(String state){
            this.state = state;
        }
        private String getState() {
            return state;
        }
        private void setState(String state) {
            this.state = state;
        }
    }
}
//负责人角色
class Caretaker {
    private MementoIF memento;
    public MementoIF retrieveMemento(){
        return memento;
    }
    public void saveMemento(MementoIF memento){
        this.memento = memento;
    }
}

public class Client {
    public static void main(String[] args) {
        Originator o = new Originator();
        Caretaker c = new Caretaker();
        //改变负责人对象的状态
        o.setState("On");
        //创建备忘录对象，并将发起人对象的状态存储起来
        c.saveMemento(o.createMemento());
        //修改发起人对象的状态
        o.setState("Off");
        //恢复发起人对象的状态
        o.restoreMemento(c.retrieveMemento());
    }
}
