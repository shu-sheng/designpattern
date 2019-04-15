package structuralpattern.decoratorpattern.demo01;

/**
 * @Description 装饰者模式
 * @Author Created by shusheng.
 * @Email shusheng@yiji.com
 * @Date 2017-08-02
 */
//定义被装饰者
interface Human {
    public void wearClothes();
    public void walkToWhere();
}

//定义装饰者
abstract class Decorator implements Human {
    private Human human;
    public Decorator(Human human) {
        this.human = human;
    }

    public void wearClothes() {
        human.wearClothes();
    }
    public void walkToWhere() {
        human.walkToWhere();
    }
}

//下面定义三种装饰，这是第一个，第二个第三个功能依次细化，即装饰者的功能越来越多
class Decorator1 extends Decorator {

    public Decorator1(Human human) {
        super(human);
    }

    public void goHome() {
        System.out.println("进房子。。");
    }
    @Override
    public void wearClothes() {
        super.wearClothes();
        goHome();
    }

    public void findMap() {
        System.out.println("书房找找Map。。");
    }
    @Override
    public void walkToWhere() {
        super.walkToWhere();
        findMap();
    }
}

class Decorator2 extends Decorator {

    public Decorator2(Human human) {
        super(human);
    }
    public void goClothespress() {
        System.out.println("去衣柜找找看。。");
    }
    @Override
    public void wearClothes() {
        super.wearClothes();
        goClothespress();
    }

    public void findPlaceOnMap() {
        System.out.println("在Map上找找。。");
    }
    @Override
    public void walkToWhere() {
        super.walkToWhere();
        findPlaceOnMap();
    }
}

class Decorator3 extends Decorator {

    public Decorator3(Human human) {
        super(human);
    }
    public void findClothes() {
        System.out.println("找到一件D&G。。");
    }
    @Override
    public void wearClothes() {
        super.wearClothes();
        findClothes();
    }

    public void findTheTarget() {
        System.out.println("在Map上找到神秘花园和城堡。。");
    }
    @Override
    public void walkToWhere() {
        super.walkToWhere();
        findTheTarget();
    }
}

//定义被装饰者
class Person implements Human {
    @Override
    public void wearClothes() {
        System.out.println("穿什么呢。。");
    }
    @Override
    public void walkToWhere() {
        System.out.println("去哪里呢。。");
    }
}
//测试类，看一下你就会发现，跟java的I/O操作有多么相似
public class Client01 {
    public static void main(String[] args) {
        Human person = new Person();
        Decorator decorator = new Decorator3(new Decorator2(
                new Decorator1(person)));
        decorator.wearClothes();
        System.out.println("-----------------------------");
        decorator.walkToWhere();
    }
}
