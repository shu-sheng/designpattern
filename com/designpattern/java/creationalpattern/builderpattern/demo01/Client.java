package creationalpattern.builderpattern.demo01;

/**
 * @author shusheng
 * @description
 * @Email eric_wu_peng@126.com
 * @date 2019/4/12 17:58
 */
public class Client {

    public static void main(String[] args) {
        new Client().construct();
    }

    public void construct() {
        Builder builder = new HolidayBuilder();
//        Builder builder = new OldCustomerBuilder();

        builder.buildApple(120);//创建苹果设置价格
        builder.buildBanana(80);//创建香蕉设置香蕉价格
        builder.buildOrange(50);//创建桔子设置价格

        FruitMeal fruitMeal = builder.getFruitMeal();


        fruitMeal.cost();
    }

}
