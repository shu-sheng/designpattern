package structuralpattern.proxypattern.demo03;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author shusheng
 * @description Cglib代理
 * @Email eric_wu_peng@126.com
 * @date 2019/4/16 0:14
 */
class UserDao {
    /*目标对象,没有实现任何接口*/
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}

/**
 * Cglib子类代理工厂
 * 对UserDao在内存中动态构建一个子类对象
 */
class ProxyFactory implements MethodInterceptor {
    //维护目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //给目标对象创建一个代理对象
    public Object getProxyInstance(){
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(target.getClass());
        //3.设置回调函数
        en.setCallback(this);
        //4.创建子类(代理对象)
        return en.create();

    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("开始事务...");

        //执行目标对象的方法
        Object returnValue = method.invoke(target, args);

        System.out.println("提交事务...");

        return returnValue;
    }
}

public class Client03 {

    public static void main(String[] args) {
        //目标对象
        UserDao target = new UserDao();
        //代理对象
        UserDao proxy = (UserDao)new ProxyFactory(target).getProxyInstance();
        //执行代理对象的方法
        proxy.save();
    }

}
