package creationalpattern.prototypepattern;

/**
 * @Description 浅拷贝
 * @Author Created by shusheng.
 * @Email shusheng@yiji.com
 * @Date 2017-07-12
 */
class AuthorA {

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

class BookA implements Cloneable {

    private String title;
    private int pageNum;
    private AuthorA author;

    public BookA clone() {
        BookA book = null;
        try {
            book = (BookA) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return book;
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

    public AuthorA getAuthorA() {
        return author;
    }

    public void setAuthorA(AuthorA author) {
        this.author = author;
    }

}

public class PrototypeTest1 {

    public static void main(String[] args) {

        BookA book1 = new BookA();
        AuthorA author = new AuthorA();
        author.setName("corn");
        author.setAge(100);
        book1.setAuthorA(author);
        book1.setTitle("好记性不如烂博客");
        book1.setPageNum(230);

        BookA book2 = book1.clone();

        System.out.println(book1 == book2);  // false
        System.out.println(book1.getPageNum() == book2.getPageNum());   // true
        System.out.println(book1.getTitle() == book2.getTitle());        // true
        System.out.println(book1.getAuthorA() == book2.getAuthorA());        // true

    }

}
