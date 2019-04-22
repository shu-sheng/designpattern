package behavioralpattern.mediatorpattern.demo01.Colleague;

import behavioralpattern.mediatorpattern.demo01.Mediator;

/**
 * @author shusheng
 * @description
 * @Email eric_wu_peng@126.com
 * @date 2019/4/22 20:39
 */ //同事类——声卡
public class SoundCard extends Colleague {
    /**构造函数*/
    public SoundCard(Mediator mediator) {
        super(mediator);
    }
    /**按照声频数据发出声音*/
    public void soundData(String data){
        System.out.println("画外音：" + data);
    }
}
