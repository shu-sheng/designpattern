package behavioralpattern.iteratorpattern.demo01;

import behavioralpattern.iteratorpattern.demo01.aggregate.Aggregate;
import behavioralpattern.iteratorpattern.demo01.aggregate.ConcreteAggregate;
import behavioralpattern.iteratorpattern.demo01.iterator.Iterator;

/**
 * @author shusheng
 * @description 白箱聚集与外禀迭代子
 * @Email eric_wu_peng@126.com
 * @date 2019/4/22 20:29
 */
public class Client {

    public void operation(){
        Object[] objArray = {"One","Two","Three","Four","Five","Six"};
        //创建聚合对象
        Aggregate agg = new ConcreteAggregate(objArray);
        //循环输出聚合对象中的值
        Iterator it = agg.createIterator();
        while(!it.isDone()){
            System.out.println(it.currentItem());
            it.next();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.operation();
    }

}
