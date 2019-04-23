package creationalpattern.builderpattern.demo01.fruit;

/**
 * @author shusheng
 * @description
 * @Email eric_wu_peng@126.com
 * @date 2019/4/12 16:40
 */
public class Orange {

    private int price = 100;

    public Orange(){
    }

    public Orange(int price){
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
        return "Orange{" +
                "price=" + price +
                '}';
    }
}
