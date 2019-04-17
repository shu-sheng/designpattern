package structuralpattern.facadepattern.demo01;

/**
 * @Description 外观模式
 * @Author Created by shusheng.
 * @Email shusheng@yiji.com
 * @Date 2017-08-02
 */
class SubSystemA {
    public void MethodA() {
        //业务实现代码
    }
}
class SubSystemB {
    public void MethodB() {
        //业务实现代码
    }
}
class SubSystemC {
    public void MethodC() {
        //业务实现代码
    }
}

class Facade {
    private SubSystemA obj1 = new SubSystemA();
    private SubSystemB obj2 = new SubSystemB();
    private SubSystemC obj3 = new SubSystemC();

    public void Method() {
        obj1.MethodA();
        obj2.MethodB();
        obj3.MethodC();
    }
}

public class Client{
    public static void Main(String[] args) {
        Facade facade = new Facade();
        facade.Method();
    }
}
