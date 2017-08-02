package adapterpattern;

/**
 * @Description
 * @Author Created by shusheng.
 * @Email shusheng@yiji.com
 * @Date 2017-07-17
 */
class Adaptee {
    public int get220v(){
        return 220;
    }
}

interface Target {
    int get110v();
    int get220v();
}

class Adapter extends Adaptee implements Target{
    public int get110v(){
        return 110;
    }
}

public class Client3 {

    public static void main(String rags[]) {
        new Client3().test();
    }

    public void test() {
        Target target = new Adapter();
        int v1 = target.get110v();
        int v2 = target.get220v();
    }

}
