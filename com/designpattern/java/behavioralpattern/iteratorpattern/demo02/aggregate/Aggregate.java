package behavioralpattern.iteratorpattern.demo02.aggregate;

import behavioralpattern.iteratorpattern.demo02.iterator.Iterator;

/**
 * @author shusheng
 * @description
 * @Email eric_wu_peng@126.com
 * @date 2019/4/23 0:14
 */
public abstract class Aggregate {
    /**
     * 工厂方法，创建相应迭代子对象的接口
     */
    public abstract Iterator createIterator();
}
