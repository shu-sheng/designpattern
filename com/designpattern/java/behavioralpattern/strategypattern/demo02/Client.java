package behavioralpattern.strategypattern.demo02;

/**
 * @author shusheng
 * @description
 * @Email eric_wu_peng@126.com
 * @date 2019/4/20 20:24
 */
//抽象策略
interface Strategy {
    //加密
    public void encrypt();
}

//具体策略
class MD5Strategy implements Strategy {
    public void encrypt() {
        System.out.println("执行MD5加密");
    }
}

class SHA1Strategy implements Strategy {
    public void encrypt() {
        System.out.println("执行SHA1加密");
    }
}

//封装类
class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void encrypt() {
        this.strategy.encrypt();
    }
}

public class Client {
    public static void main(String[] args) {
        Strategy stra = new SHA1Strategy();
        stra.encrypt();
        System.out.println("------------------------------------");
        Context context = new Context(new MD5Strategy());
        context.encrypt();
    }
}
