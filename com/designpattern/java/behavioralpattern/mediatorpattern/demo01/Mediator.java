package behavioralpattern.mediatorpattern.demo01;

import behavioralpattern.mediatorpattern.demo01.Colleague.Colleague;

/**
 * @author shusheng
 * @description
 * @Email eric_wu_peng@126.com
 * @date 2019/4/22 20:40
 */ //抽象调停者类
public interface Mediator {
    /**
     * 同事对象在自身改变的时候来通知调停者方法
     * 让调停者去负责相应的与其他同事对象的交互
     */
    public void changed(Colleague c);
}
