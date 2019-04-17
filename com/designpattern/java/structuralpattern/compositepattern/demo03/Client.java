package structuralpattern.compositepattern.demo03;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description 透明式组合模式
 * @Author Created by shusheng.
 * @Email shusheng@yiji.com
 * @Date 2017-08-01
 */
// 抽象构件类、节点类
abstract class Component {
    public String name;

    public Component(String name) {
        this.name = name;
    }

    // 增加一个节点
    public abstract void add(Component component);
    // 移除一个节点
    public abstract void remove(Component component);
    //显示层级结构
    public abstract void display(int level);

    // 公有操作
    public void getName() {
        System.out.println(this.name);
    }
}

// 树叶构件类
class Leaf extends Component {
    public Leaf(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        System.out.println("Can not add a component to a leaf");
    }

    @Override
    public void remove(Component component) {
        System.out.println("Can not remove a component to a leaf");
    }

    @Override
    public void display(int level) {
        System.out.println(level+"--"+name);
    }
}

// 树根树枝构件类
class Composite extends Component {

    private List<Component> children = new LinkedList<>();

    public Composite(String name) {
        super(name);
    }

    @Override
    public void add(Component component) {
        children.add(component);
    }
    @Override
    public void remove(Component component) {
        children.remove(component);
    }
    @Override
    public void display(int level) {
        System.out.print(level);
        for(int i=0;i<=level;i++){
            System.out.print("---");
        }
        System.out.println(name);
        for(Component c:children){
            c.display(level+1);
        }
    }
}



public class Client {

    public static void main(String[] args) {
        Component root = new Composite("树根");

        Component branch01 = new Composite("树枝01");
        Component branch02 = new Composite("树枝02");

        root.add(branch01);
        root.add(branch02);

        Component leaf01 = new Leaf("树叶01");
        Component leaf02 = new Leaf("树叶02");
        Component leaf03 = new Leaf("树叶03");
        Component leaf04 = new Leaf("树叶04");
        Component leaf05 = new Leaf("树叶05");

        branch01.add(leaf01);
        branch01.add(leaf02);

        branch02.add(leaf03);
        branch02.add(leaf04);
        branch02.add(leaf05);

        root.display(1);
    }

}
