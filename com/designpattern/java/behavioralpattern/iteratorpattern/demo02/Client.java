package behavioralpattern.iteratorpattern.demo02;

import behavioralpattern.iteratorpattern.demo02.aggregate.Aggregate;
import behavioralpattern.iteratorpattern.demo02.aggregate.ConcreteAggregate;
import behavioralpattern.iteratorpattern.demo02.iterator.Iterator;

/**
 * @author shusheng
 * @description 黑箱聚集与内禀迭代子
 * @Email eric_wu_peng@126.com
 * @date 2019/4/23 0:13
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
