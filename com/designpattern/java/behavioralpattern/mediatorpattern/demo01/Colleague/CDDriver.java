package behavioralpattern.mediatorpattern.demo01.Colleague;

import behavioralpattern.mediatorpattern.demo01.Mediator;

/**
 * @author shusheng
 * @description
 * @Email eric_wu_peng@126.com
 * @date 2019/4/22 20:39
 */ //同事类——光驱
public class CDDriver extends Colleague {
    //光驱读取出来的数据
    private String data = "";
    /**构造函数*/
    public CDDriver(Mediator mediator) {
        super(mediator);
    }
    /**获取光盘读取出来的数据*/
    public String getData() {
        return data;
    }
    /**读取光盘*/
    public void readCD(){
        //逗号前是视频显示的数据，逗号后是声音
        this.data = "One Piece,海贼王我当定了";
        //通知主板，自己的状态发生了改变
        getMediator().changed(this);
    }
}
