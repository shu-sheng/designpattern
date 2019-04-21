package behavioralpattern.commandpattern.demo01;

/**
 * @author shusheng
 * @description
 * @Email eric_wu_peng@126.com
 * @date 2019/4/21 14:29
 */
class HotHandler {
    public String getHots(){
        System.out.println("返回热门商品列表");
        return "热门商品列表";
    }
}
class NewerHandler {
    public String getNewers(){
        System.out.println("返回最新商品列表");
        return "最新商品列表";
    }
}
class DiscountHandler {
    public String getDiscounts(){
        System.out.println("返回优惠商品列表");
        return "优惠商品列表";
    }
}
abstract class Command {
    public abstract String execute();
}
class HotCommand extends Command {
    private HotHandler handler = new HotHandler();
    @Override
    public String execute() {
        return handler.getHots();
    }
}
class NewerCommand extends Command {
    private NewerHandler handler = new NewerHandler();
    @Override
    public String execute() {
        return handler.getNewers();
    }
}
class DiscountCommand extends Command {
    private DiscountHandler handler = new DiscountHandler();
    @Override
    public String execute() {
        return handler.getDiscounts();
    }
}
/**
 * 命令模式：将方法调用本身，包装成一个对象（命令对象）
 * 订单支付过程
 */
class ListView {
    private Command command; //维持一个抽象命令对象的引用
    //为功能键注入命令
    public void setCommand(Command command) {
        this.command = command;
    }
    //请求列表
    public void getList() {
        System.out.print("首页请求");
        String result = command.execute();
        System.out.println("当前列表："+result);
    }
}

public class Client {
    public static void main(String[] args) {
        //三个命令，代表三个请求
        Command command1,command2,command3;
        command1 = new HotCommand();
        command2 = new NewerCommand();
        command3 = new DiscountCommand();

        ListView listView = new ListView();
        listView.setCommand(command2);

        listView.getList();
    }
}
