package structuralpattern.proxypattern.demo02;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author shusheng
 * @description 动态代理
 * @Email eric_wu_peng@126.com
 * @date 2019/4/16 0:11
 */
interface IUserDao {
    void save();
}
class UserDao implements IUserDao {
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}

class ProxyFactory {
    //维护一个目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //给目标对象生成代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("开始事务2");
                        //执行目标对象方法
                        Object returnValue = method.invoke(target, args);
                        System.out.println("提交事务2");
                        return returnValue;
                    }
                }
        );
    }

}

public class Client02 {
    public static void main(String[] args) {
        // 目标对象
        IUserDao target = new UserDao();
        System.out.println(target.getClass());

        // 给目标对象，创建代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        //内存中动态生成的代理对象
        System.out.println(proxy.getClass());

        // 执行方法【代理对象】
        proxy.save();
    }
}
