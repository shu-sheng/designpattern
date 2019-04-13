package creationalpattern.singletonpattern.demo1;

/**
 * @author shusheng
 * @description
 * @Email eric_wu_peng@126.com
 * @date 2019/4/13 17:30
 */
public class SessionCountClient {

    public static void main(String[] args) {
        //营业开门
        SessionCount count = SessionCount.getSessionCount();
        count.plus();
        count.showMessage();

        SessionCount count1 = SessionCount.getSessionCount();
        count1.plus();
        count1.showMessage();

        //出去一个
        SessionCount count2 = SessionCount.getSessionCount();
        count2.decrease();
        count2.showMessage();
    }

}
