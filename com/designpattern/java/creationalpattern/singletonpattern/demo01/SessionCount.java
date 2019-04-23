package creationalpattern.singletonpattern.demo01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shusheng
 * @description
 * @Email eric_wu_peng@126.com
 * @date 2019/4/13 12:30
 */
public class SessionCount {
    private AtomicInteger count = new AtomicInteger(0);

    //懒汉式
    private static SessionCount sessionCount;

    private SessionCount(){
    }

    //获取唯一可用的对象
    //懒汉式
    public static SessionCount getSessionCount(){
        if (sessionCount == null){
            //双重校验
            //只对创建这个行为加锁
            synchronized (SessionCount.class){
                if (sessionCount == null){
                    sessionCount = new SessionCount();
                }
            }
        }
        return sessionCount;
    }

    /***以下是业务方法***/
    public int plus(){
        return count.incrementAndGet();
    }

    public int decrease(){
        return count.decrementAndGet();
    }

    public void showMessage(){
        System.out.println("当前人数："+this.count.get());
    }

}
