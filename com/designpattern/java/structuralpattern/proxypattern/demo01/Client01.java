package structuralpattern.proxypattern.demo01;

/**
 * @author shusheng
 * @description 静态代理
 * @Email eric_wu_peng@126.com
 * @date 2019/4/15 23:47
 */
interface IUserDao {
    void save();
}
class UserDao implements IUserDao {
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}
class UserDaoProxy implements IUserDao{
    //接收保存目标对象
    private IUserDao target;
    public UserDaoProxy(IUserDao target){
        this.target=target;
    }

    public void save() {
        System.out.println("开始事务...");
        target.save();//执行目标对象的方法
        System.out.println("提交事务...");
    }
}

public class Client01 {
    public static void main(String[] args) {
        //目标对象
        IUserDao target = new UserDao();

        //代理对象,把目标对象传给代理对象,建立代理关系
        UserDaoProxy proxy = new UserDaoProxy(target);

        proxy.save();//执行的是代理的方法
    }
}
