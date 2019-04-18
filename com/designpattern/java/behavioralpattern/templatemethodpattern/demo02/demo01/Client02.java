package behavioralpattern.templatemethodpattern.demo02.demo01;

import sun.nio.cs.FastCharsetProvider;

/**
 * @author shusheng
 * @description （具有钩子方法的）模板方法设计模式
 * @Email eric_wu_peng@126.com
 * @date 2019/4/18 16:56
 */
abstract class HouseTemplate {
    protected String name;

    protected HouseTemplate(String name){
        this.name = name;
    }

    protected abstract void buildDoor();
    protected abstract void buildWindow();
    protected abstract void buildWall();
    protected abstract void buildBase();
    protected abstract void  buildToilet();
    //钩子方法
    protected boolean isBuildToilet(){
        return true;
    }

    //公共逻辑
    public final void buildHouse(){
        buildBase();
        buildWall();
        buildDoor();
        buildWindow();
        if(isBuildToilet()){
            buildToilet();
        }
    }

}

class HouseOne extends HouseTemplate {
    public boolean isBuildToilet;

    HouseOne(String name,boolean isBuildToilet){
        super(name);
        this.isBuildToilet = isBuildToilet;
    }

    @Override
    protected void buildDoor() {
        System.out.println(name +"的门要采用防盗门");
    }
    @Override
    protected void buildWindow() {
        System.out.println(name + "的窗户要面向北方");
    }
    @Override
    protected void buildWall() {
        System.out.println(name + "的墙使用大理石建造");
    }
    @Override
    protected void buildBase() {
        System.out.println(name + "的地基使用钢铁地基");
    }
    @Override
    protected void buildToilet() {
        System.out.println(name + "的厕所建在东南角");
    }

    @Override
    protected boolean  isBuildToilet() {
        return isBuildToilet;
    }

}

class HouseTwo extends HouseTemplate {

    HouseTwo(String name){
        super(name);
    }

    @Override
    protected void buildDoor() {
        System.out.println(name + "的门采用木门");
    }
    @Override
    protected void buildWindow() {
        System.out.println(name + "的窗户要向南");
    }
    @Override
    protected void buildWall() {
        System.out.println(name + "的墙使用玻璃制造");
    }
    @Override
    protected void buildBase() {
        System.out.println(name + "的地基使用花岗岩");
    }
    @Override
    protected void buildToilet() {
        System.out.println(name + "的厕所建在西北角");
    }

}

public class Client02 {

    public static void main(String[] args){
        HouseTemplate houseOne = new HouseOne("房子1",false);
        HouseTemplate houseTwo = new HouseTwo("房子2");
        houseOne.buildHouse();
        System.out.println("-----------------休息一下--------------------------");
        houseTwo.buildHouse();
    }

}
