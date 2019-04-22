package behavioralpattern.mementopattern.demo04;

/**
 * @author shusheng
 * @description 自述历史模式
 * @Email eric_wu_peng@126.com
 * @date 2019/4/22 17:38
 */
interface MementoIF {
}

class Originator {
    public String state;
    /**改变状态*/
    public void changeState(String state){
        this.state = state;
        System.out.println("状态改变为：" + state);
    }
    /**工厂方法，返还一个新的备忘录对象*/
    public Memento createMemento(){
        return new Memento(this);
    }
    /**将发起人恢复到备忘录对象所记录的状态上*/
    public void restoreMemento(MementoIF memento){
        Memento m = (Memento)memento;
        changeState(m.state);
    }

    private class Memento implements MementoIF{
        private String state;
        /**构造方法*/
        private Memento(Originator o){
            this.state = o.state;
        }
        private String getState() {
            return state;
        }
    }
}

public class Client {
    public static void main(String[] args) {
        Originator o = new Originator();
        //修改状态
        o.changeState("state 0");
        //创建备忘录
        MementoIF memento = o.createMemento();
        //修改状态
        o.changeState("state 1");
        //按照备忘录恢复对象的状态
        o.restoreMemento(memento);
    }
}
