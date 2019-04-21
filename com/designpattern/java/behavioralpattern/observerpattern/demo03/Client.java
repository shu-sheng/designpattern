package behavioralpattern.observerpattern.demo03;

/**
 * @author shusheng
 * @description
 * @Email eric_wu_peng@126.com
 * @date 2019/4/21 17:22
 */
/**抽象主题，朋友圈*/

import java.util.ArrayList;
import java.util.List;

/**抽象观察者，看朋友圈的人*/
interface ITalkObserver {
    //更新朋友圈
    void updateTalk(String msg);
}
interface ITalkSubject {
    //让某些人看见我的朋友圈
    void addObserver(ITalkObserver observer);
    //不然某些人看见我的朋友圈
    void deleteObserver(ITalkObserver observer);
    //刷新，让朋友知道
    void notifyObserver();
}
/**具体的看朋友圈的人*/
class ConcreteTalkObserver implements ITalkObserver {
    //姓名
    private String name;
    //构造方法，传入姓名
    public ConcreteTalkObserver(String name){
        this.name=name;
    }
    //关注的朋友圈，数据更新了
    @Override
    public void updateTalk(String msg) {
        System.out.println(name+" 收到一条朋友圈的更新："+msg);
    }
}
/**具体的朋友圈*/
class ConcreteTalkSubject implements ITalkSubject {
    //观察者集合，管理那些人能看我的朋友圈
    private List<ITalkObserver> observerList = new ArrayList<>();
    //朋友圈消息
    private String msg;
    //设置朋友圈信息
    public void setMessage(String msg) {
        this.msg = msg;
        notifyObserver();//刷新
    }
    //增加可以看我朋友圈的人
    @Override
    public void addObserver(ITalkObserver observer) {
        observerList.add(observer);
    }
    //删除可以看我朋友圈的人
    @Override
    public void deleteObserver(ITalkObserver observer) {
        observerList.remove(observer);
    }
    //刷新,让看我朋友圈的人都知道：我更新信息了
    @Override
    public void notifyObserver() {
        for (int i = 0; i < observerList.size(); i++) {
            observerList.get(i).updateTalk(msg);//給每一个观察者刷新一下
        }
    }
}

public class Client {
    public static void main(String[] arg) {
        //创建一个朋友圈
        ConcreteTalkSubject talkSubject = new ConcreteTalkSubject();
        //看朋友圈的人
        ITalkObserver talk1 = new ConcreteTalkObserver("书生");
        ITalkObserver talk2 = new ConcreteTalkObserver("白胖娃");
        //把看朋友圈的人添加到朋友圈中
        talkSubject.addObserver(talk1);
        talkSubject.addObserver(talk2);
        //添加朋友圈信息，别人就可以看到
        talkSubject.setMessage("今天看到一个老大爷摔倒在地上，没有人去扶老大爷！");
    }
}
