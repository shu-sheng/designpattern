package creationalpattern.builderpattern.demo1.fruit;

/**
 * @author shusheng
 * @description
 * @Email eric_wu_peng@126.com
 * @date 2019/4/12 16:40
 */
public class Apple {

    private int price = 100;

    public Apple(){
    }

    public Apple(int price){
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "price=" + price +
                '}';
    }
}
