package behavioralpattern.mediatorpattern.demo01.Colleague;

import behavioralpattern.mediatorpattern.demo01.Mediator;

/**
 * @author shusheng
 * @description
 * @Email eric_wu_peng@126.com
 * @date 2019/4/22 20:29
 */
//抽象同事类
public abstract class Colleague {
    //持有一个调停者对象
    private Mediator mediator;
    /**
     * 构造函数
     */
    public Colleague(Mediator mediator){
        this.mediator = mediator;
    }
    /**
     * 获取当前同事类对应的调停者对象
     */
    public Mediator getMediator() {
        return mediator;
    }
}
