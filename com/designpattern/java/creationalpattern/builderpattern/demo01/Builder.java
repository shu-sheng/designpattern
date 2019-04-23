package creationalpattern.builderpattern.demo01;

/**
 * @author shusheng
 * @description
 * @Email eric_wu_peng@126.com
 * @date 2019/4/12 17:53
 */
public interface Builder {

    void buildApple(int price);//设置苹果
    void buildBanana(int price);//设置香蕉
    void buildOrange(int price);//设置桔子

    FruitMeal getFruitMeal();//返回创建的套餐

}
