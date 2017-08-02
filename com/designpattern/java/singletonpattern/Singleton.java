package singletonpattern;

/**
 * @Description
 * @Author Created by shusheng.
 * @Email shusheng@yiji.com
 * @Date 2017-07-03
 */
public class Singleton {

    public static void main(String[] args)
    {
        //创建SingletonPattern对象不能通过构造器，只能通过getInstance方法
        Singleton s1 = Singleton.getSingleton();
        Singleton s2 = Singleton.getSingleton();
        //将输出true
        System.out.println(s1 == s2);
    }
    //使用一个变量来缓存曾经创建的实例
    private static Singleton singleton;
    //将构造器使用private修饰，隐藏该构造器
    private Singleton(){
        System.out.println("Singleton被构造！");
    }
    //提供一个静态方法，用于返回Singleton实例
    //该方法可以加入自定义的控制，保证只产生一个Singleton对象
    public static Singleton getSingleton()
    {
        //如果instance为null，表明还不曾创建Singleton对象
        //如果instance不为null，则表明已经创建了Singleton对象，将不会执行该方法
        if (singleton == null)
        {
            //创建一个Singleton对象，并将其缓存起来
            singleton = new Singleton();
        }
        return singleton;
    }

}
