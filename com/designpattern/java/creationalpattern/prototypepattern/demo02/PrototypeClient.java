package creationalpattern.prototypepattern.demo02;

import java.io.*;

/**
 * @Description 采用序列化的方式实现深克隆
 * @Author Created by shusheng.
 * @Email shusheng@yiji.com
 * @Date 2017-07-12
 */
class AuthorB implements Serializable {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

class BookB implements Serializable {

    private String title;
    private int pageNum;
    private AuthorB author;

    public BookB deepClone() throws IOException, ClassNotFoundException{
        // 写入当前对象的二进制流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        // 读出二进制流产生的新对象
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (BookB) ois.readObject();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public AuthorB getAuthorB() {
        return author;
    }

    public void setAuthorB(AuthorB author) {
        this.author = author;
    }

}

public class PrototypeClient {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        BookB book1 = new BookB();
        AuthorB author = new AuthorB();
        author.setName("corn");
        author.setAge(100);
        book1.setAuthorB(author);
        book1.setTitle("好记性不如烂博客");
        book1.setPageNum(230);

        BookB book2 = book1.deepClone();

        System.out.println(book1 == book2);  // false
        System.out.println(book1.getPageNum() == book2.getPageNum());   // true
        System.out.println(book1.getTitle() == book2.getTitle());        // false
        System.out.println(book1.getAuthorB() == book2.getAuthorB());        // false
        System.out.println(book1.getAuthorB().getName() == book2.getAuthorB().getName()); // false

    }
}
