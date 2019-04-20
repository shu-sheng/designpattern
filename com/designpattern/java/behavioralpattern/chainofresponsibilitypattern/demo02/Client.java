package behavioralpattern.chainofresponsibilitypattern.demo02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shusheng
 * @description
 * @Email eric_wu_peng@126.com
 * @date 2019/4/20 23:31
 */
//封装请求的类Request
class Request {
    String requestStr;
    public String getRequest() {
        return requestStr;
    }
    public void setRequest(String request) {
        this.requestStr = request;
    }
}
//封装响应信息的类Response
class Response {
    String responseStr;
    public String getResponse() {
        return responseStr;
    }
    public void setResponse(String response) {
        this.responseStr = response;
    }
}
//过滤链条
class FilterChain implements Filter{
    //用List集合来存储过滤规则
    List<Filter> filters = new ArrayList<Filter>();
    //用于标记规则的引用顺序
    int index=0;
    //往规则链条中添加规则
    public FilterChain addFilter(Filter f) {
        filters.add(f);
        //代码的设计技巧:Chain链添加过滤规则结束后返回添加后的Chain，方便我们下面doFilter函数的操作
        return this;
    }
    public void doFilter(Request request,Response response,FilterChain chain){
        //index初始化为0,filters.size()为3，不会执行return操作
        if(index==filters.size()){
            return;
        }
        //每添加一个过滤规则，index自增1
        Filter f=filters.get(index);
        index++;
        //根据索引值获取对应的规律规则对字符串进行处理
        f.doFilter(request, response, chain);
    }
}
interface Filter {
    void doFilter(Request request,Response response,FilterChain chain);
}
//处理字符串中的HTML标记
class HTMLFilter implements Filter {
    public void doFilter(Request request, Response response,FilterChain chain) {
        //将字符串中出现的"<>"符号替换成"[]"
        request.requestStr=request.requestStr
                .replace('<', '[').replace('>', ']')+
                //后面添加的是便于我们观察代码执行步骤的字符串
                "----HTMLFilter()";
        chain.doFilter(request, response,chain);
        response.responseStr+="---HTMLFilter()";
    }
}
//定义的过滤敏感字眼的过滤规则
class SensitiveFilter implements Filter{
    public void doFilter(Request request, Response response,FilterChain chain) {
        //处理字符串中的敏感信息，将被就业和谐成就业
        request.requestStr=request.requestStr
                .replace("被就业", "就业").replace("敏感", "")+
                //后面添加的是便于我们观察代码执行步骤的字符串
                " ---sensitiveFilter()";
        chain.doFilter(request, response,chain);
        response.responseStr+="---sensitiveFilter()";
    }
}
//定义FaceFilter
class FaceFilter implements Filter {
    public void doFilter(Request request, Response response, FilterChain chain) {
        //将字符串中出现的":):"转换成"^V^";
        request.requestStr = request.requestStr.replace(":):", "^V^")
                //后面添加的是便于我们观察代码执行步骤的字符串
                + "----FaceFilter()";
        chain.doFilter(request, response, chain);
        response.responseStr += "---FaceFilter()";
    }
}
/**
 * 责任链模式：
 * 数据消息在进入数据库之前，要被多种过滤规则进行处理，多种规则形成一种链，依次处理
 * 给定的数据消息
 */
public class Client {
    public static void main(String args[]) {
        //设定过滤规则，对msg字符串进行过滤处理
        String msg = ":):,<script>,敏感,被就业,网络授课";
        //过滤请求
        Request request=new Request();
        //set方法，将待处理字符串传递进去
        request.setRequest(msg);
        //处理过程结束，给出的响应
        Response response=new Response();
        //设置响应信息
        response.setResponse("response:");
        //FilterChain,过滤规则形成的拦截链条
        FilterChain fc=new FilterChain();
        //规则链条添加过滤规则，采用的是链式调用
        fc.addFilter(new HTMLFilter())
                .addFilter(new SensitiveFilter())
                .addFilter(new FaceFilter());
        //按照FilterChain的规则顺序，依次应用过滤规则
        fc.doFilter(request, response,fc);
        //打印请求信息
        System.out.println(request.getRequest());
        //打印响应信息
        System.out.println(response.getResponse());
    }
}
