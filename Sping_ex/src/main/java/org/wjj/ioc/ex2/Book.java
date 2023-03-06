package org.wjj.ioc.ex2;

/**
 * @author :wjj
 * @date : 2023/3/6
 */
public class Book {

    private int code;
    private String book_name;
    private int price;

    public Book(int code, String book_name, int price) {
        System.out.print("book对象通过带参构造方式创建");
        this.code = code;
        this.book_name = book_name;
        this.price = price;
    }

    public Book(){

    }

    @Override
    public String toString() {
        return "Book{" +
                "code=" + code +
                ", book_name='" + book_name + '\'' +
                ", price=" + price +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
