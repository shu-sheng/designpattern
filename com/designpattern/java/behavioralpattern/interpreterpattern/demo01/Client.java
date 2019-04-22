package behavioralpattern.interpreterpattern.demo01;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shusheng
 * @description
 * @Email eric_wu_peng@126.com
 * @date 2019/4/22 10:01
 */
//上下文类（这里主要用来将变量解析成数字【当然一开始要先定义】
class Context {
    private Map<Expression, Integer> map = new HashMap<>();
    //定义变量
    public void add(Expression s, Integer value){
        map.put(s, value);
    }
    //将变量转换成数字
    public int lookup(Expression s){
        return map.get(s);
    }
}

interface Expression {
    int interpreter(Context context);//一定会有解释方法
}
//终结符表达式
class TerminalExpression implements Expression{
    String variable;
    public TerminalExpression(String variable){
        this.variable = variable;
    }
    @Override
    public int interpreter(Context context) {
        return context.lookup(this);
    }
}
//抽象非终结符表达式
abstract class NonTerminalExpression implements Expression{
    Expression e1,e2;
    public NonTerminalExpression(Expression e1, Expression e2){
        this.e1 = e1;
        this.e2 = e2;
    }
}
//减法表达式实现类
class MinusOperation extends NonTerminalExpression {
    public MinusOperation(Expression e1, Expression e2) {
        super(e1, e2);
    }
    //将两个表达式相减
    @Override
    public int interpreter(Context context) {
        return this.e1.interpreter(context) - this.e2.interpreter(context);
    }
}
//加法表达式实现类
class PlusOperation extends NonTerminalExpression {
    public PlusOperation(Expression e1, Expression e2) {
        super(e1, e2);
    }
    //将两个表达式相加
    @Override
    public int interpreter(Context context) {
        return this.e1.interpreter(context) + this.e2.interpreter(context);
    }
}

//测试类
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        TerminalExpression terminalExpressionA = new TerminalExpression("a");
        TerminalExpression terminalExpressionB = new TerminalExpression("b");
        TerminalExpression terminalExpressionC = new TerminalExpression("c");
        context.add(terminalExpressionA, 4);
        context.add(terminalExpressionB, 8);
        context.add(terminalExpressionC, 2);
        NonTerminalExpression nonTerminalExpression1 = new PlusOperation(terminalExpressionA,terminalExpressionB);
        NonTerminalExpression nonTerminalExpression2 = new MinusOperation(nonTerminalExpression1, terminalExpressionC);
        System.out.println(nonTerminalExpression2.interpreter(context));
    }
}
