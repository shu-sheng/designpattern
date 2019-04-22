package behavioralpattern.mediatorpattern.demo01.Colleague;

import behavioralpattern.mediatorpattern.demo01.Mediator;

/**
 * @author shusheng
 * @description
 * @Email eric_wu_peng@126.com
 * @date 2019/4/22 20:39
 */ //同事类——显卡
public class VideoCard extends Colleague {
    /**构造函数*/
    public VideoCard(Mediator mediator) {
        super(mediator);
    }
    /**显示视频数据*/
    public void showData(String data){
        System.out.println("您正在观看的是：" + data);
    }
}
