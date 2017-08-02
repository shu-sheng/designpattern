package compositepattern;

import java.util.LinkedList;

/**
 * @Description
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

    // 公有操作
    public void getName() {
        System.out.println(this.name);
    }
}

// 树枝构件类
class Composite extends Component {

    private LinkedList<Component> children;

    public Composite(String name) {
        super(name);
        this.children = new LinkedList<Component>();
    }

    // 添加一个节点，可能是树枝、叶子
    public void add(Component child) {
        this.children.add(child);
    }

    // 删除一个节点，可能是树枝、叶子
    public void remove(String child) {
        this.children.remove(child);
    }

    // 获取子树
    public LinkedList<Component> getChildren() {
        return this.children;
    }
}

// 树叶构件类
class Leaf extends Component {

    public Leaf(String name) {
        super(name);
    }
}

public class Client2 {

    public static void main(String[] args) {

        Composite root = new Composite("树根");

        Composite branch01 = new Composite("树枝01");
        Composite branch02 = new Composite("树枝02");

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

        displayTree(root);

    }

    // 递归遍历整棵树
    public static void displayTree(Composite root) {
        LinkedList<Component> children = root.getChildren();

        for (Component c : children) {
            if (c instanceof Leaf) {
                System.out.print("\t");
                c.getName();
            } else {
                c.getName();
                // 递归
                displayTree((Composite)c);
            }
        }
    }

}
