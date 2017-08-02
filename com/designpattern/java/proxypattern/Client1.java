package proxypattern;

/**
 * @Description 代理模式
 * @Author Created by shusheng.
 * @Email shusheng@yiji.com
 * @Date 2017-08-02
 */
//新建一个买车的接口
interface buy_car {
    public void buy_mycar();
}
//新建一个people人类，具有买车的行为，所以实现接口buy_car
class people implements buy_car {

    private int cash;
    private String vip;
    private String username;

    @Override
    public void buy_mycar() {
        System.out.print(username+"是vip 客户，可以直接购买新车！");
    }

    public int getCash(){
        return cash;
    }
    public void setCash(int cash){
        this.cash = cash;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getVip(){
        return vip;
    }
    public void setVip(String vip){
        this.vip = vip;
    }
}
/*people类不能拥有车，必须经过proxy代理类的认证，符合条件之后才可以拥有车辆，
新建一个代理，这个代理类来考察当前的people是否有资格进行买车：*/
class proxyclass implements buy_car {

    private people people;
    public people getPeople(){
        return people;
    }
    public void setPeople(people people){
        this.people = people;
    }

    @Override
    public void buy_mycar() {
        if (people.getVip() == "vip"){
            people.buy_mycar();
            return ;
        }
        if(people.getCash()>=50000){
            System.out.println(people.getUsername()+"买了新车，交易结束！");
        }
        else
        {
            System.out.println(people.getUsername()+"钱不够，不能买车，继续比赛！");
        }
    }
}
//创建一个客户端，用来模拟买车的行为
public class Client1 {
    public static void main(String[] args) {
        people people_1 =new people();
        people_1.setCash(60000);
        people_1.setUsername("jeck");


        people people_2 =new people();
        people_2.setCash(40000);
        people_2.setUsername("rose");

        people people_3 =new people();

        people_3.setCash(0);
        people_3.setUsername("tom");
        people_3.setVip("vip");

        proxyclass proxy_buy = new proxyclass();
        proxy_buy.setPeople(people_1);
        proxy_buy.buy_mycar();

        proxy_buy.setPeople(people_2);
        proxy_buy.buy_mycar();

        proxy_buy.setPeople(people_3);
        proxy_buy.buy_mycar();

    }
}
