package behavioralpattern.iteratorpattern.demo01.aggregate;

import behavioralpattern.iteratorpattern.demo01.iterator.Iterator;

/**
 * @author shusheng
 * @description
 * @Email eric_wu_peng@126.com
 * @date 2019/4/23 0:09
 */ //抽象聚集角色类,规定出所有的具体聚集必须实现的接口
public abstract class Aggregate {
    /**工厂方法，创建相应迭代子对象的接口*/
    public abstract Iterator createIterator();
}
